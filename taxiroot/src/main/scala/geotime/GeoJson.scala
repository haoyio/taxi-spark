package geotime

import spray.json._

case class Feature(
    id: Option[JsValue],
    properties: Map[String, JsValue],
    geometry: RichGeometry) {

  def apply(property: String) = properties(property)
  def get(property: String) = properties.get(property)
}

case class FeatureCollection(features: Array[Feature])
  extends IndexedSeq[Feature] {

  def apply(index: Int) = features(index)
  def length = features.length
}

object GeoJsonProtocol extends DefaultJsonProtocol {
  implicit object FeatureJsonFormat extends RootJsonFormat[Feature] {
    def write(f: Feature) = {
      val buf = scala.collection.mutable.ArrayBuffer(
        "type" -> JsString("Feature"),
        "properties" -> JsObject(f.properties),
        "geometry" -> f.geometry.toJson)
      f.id.foreach(v => {
        buf += "id" -> v
      })
      JsObject(buf.toMap)
    }

    def read(value: JsValue) = {
      val jso = value.asJsObject
      val id = jso.fields.get("id")
      val properties = jso.fields("properties").asJsObject.fields
      val geometry = jso.fields("geometry").convertTo[RichGeometry]
      Feature(id, properties, geometry)
    }
  }
}
