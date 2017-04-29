package pojos;

import java.sql.Timestamp;

public class Nominanorm {
  private Long codigo;
  private String nombre1;
  private String nombre2;
  private String apellido1;
  private String apellido2;
  private String tiposangre;
  private Double altura;
  private Double peso;
  private Double numerocalzado;
  private java.sql.Timestamp fechanace;
  private String zurdodiestro;
  private Long ciudadid;
  private Long colorojosid;
  private Long estadocivilid;
  private Long epsid;
  private Long fondopensionid;
  private Long profesionid;
  private Long divisionid;

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getNombre1() {
    return nombre1;
  }

  public void setNombre1(String nombre1) {
    this.nombre1 = nombre1;
  }

  public String getNombre2() {
    return nombre2;
  }

  public void setNombre2(String nombre2) {
    this.nombre2 = nombre2;
  }

  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  public String getTiposangre() {
    return tiposangre;
  }

  public void setTiposangre(String tiposangre) {
    this.tiposangre = tiposangre;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getNumerocalzado() {
    return numerocalzado;
  }

  public void setNumerocalzado(Double numerocalzado) {
    this.numerocalzado = numerocalzado;
  }

  public Timestamp getFechanace() {
    return fechanace;
  }

  public void setFechanace(Timestamp fechanace) {
    this.fechanace = fechanace;
  }

  public String getZurdodiestro() {
    return zurdodiestro;
  }

  public void setZurdodiestro(String zurdodiestro) {
    this.zurdodiestro = zurdodiestro;
  }

  public Long getCiudadid() {
    return ciudadid;
  }

  public void setCiudadid(Long ciudadid) {
    this.ciudadid = ciudadid;
  }

  public Long getColorojosid() {
    return colorojosid;
  }

  public void setColorojosid(Long colorojosid) {
    this.colorojosid = colorojosid;
  }

  public Long getEstadocivilid() {
    return estadocivilid;
  }

  public void setEstadocivilid(Long estadocivilid) {
    this.estadocivilid = estadocivilid;
  }

  public Long getEpsid() {
    return epsid;
  }

  public void setEpsid(Long epsid) {
    this.epsid = epsid;
  }

  public Long getFondopensionid() {
    return fondopensionid;
  }

  public void setFondopensionid(Long fondopensionid) {
    this.fondopensionid = fondopensionid;
  }

  public Long getProfesionid() {
    return profesionid;
  }

  public void setProfesionid(Long profesionid) {
    this.profesionid = profesionid;
  }

  public Long getDivisionid() {
    return divisionid;
  }

  public void setDivisionid(Long divisionid) {
    this.divisionid = divisionid;
  }

  @Override
  public String toString() {
    return "[Codigo:] "+this.getCodigo()
            +" [Nombre1:] "+this.getNombre1()
            +" [Nombre2:] "+this.getNombre2()
            +" [Apellido1:] "+this.getApellido1()
            +" [Apellido2:] "+this.getApellido2()
            +" [tipoSangre:] "+this.getTiposangre()
            +" [altura:] "+this.getAltura()
            +" [peso:] "+this.getPeso()
            +" [numeroCalzado:] "+this.getNumerocalzado()
            +" [fechaNace:] "+this.getFechanace()
            +" [zurdoDiestro:] "+this.getZurdodiestro()
            +" [ciudadId:] "+this.getCiudadid()
            +" [colorOjosId:] "+this.getColorojosid()
            +" [estadoCivilId:] "+this.getEstadocivilid()
            +" [EPSId:] "+this.getEpsid()
            +" [fondoPensionId:] "+this.getFondopensionid()
            +" [profesionId:] "+this.getProfesionid()
            +" [divisionId:] "+this.getDivisionid();
  }
}

