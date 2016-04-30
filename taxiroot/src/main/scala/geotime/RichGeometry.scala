package geotime

import com.esri.core.geometry.{Geometry, GeometryEngine, SpatialReference}

import scala.language.implicitConversions

/**
  * A wrapper that provides convenience methods for using the spatial relations
  * in the ESRI GeometryEngine with a particular instance of the Geometry
  * interface and an associated SpatialReference.
  *
  * @param geometry the geometry object
  * @param spatialReference optional spatial reference; if not specified, uses
  *                         WKID 4326 a.k.a. WGS84, the standard coordinate
  *                         frame for Earth.
  */
class RichGeometry(
    val geometry: Geometry,
    val spatialReference: SpatialReference = SpatialReference.create(4326))
  extends Serializable {

  def area2D() = geometry.calculateArea2D()

  def contains(other: Geometry): Boolean =
    GeometryEngine.contains(geometry, other, spatialReference)

  def distance(other: Geometry): Double =
    GeometryEngine.distance(geometry, other, spatialReference)
}

object RichGeometry extends Serializable {
  implicit def wrapRichGeo(g: Geometry): RichGeometry = new RichGeometry(g)
}
