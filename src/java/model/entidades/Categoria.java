/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;
/**
 *
 * @author carlos
 */

public class Categoria{

    int id_categoria;
    String descripcion;

    public Categoria() {
    }

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }
   
    public Categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria(Integer id_categoria, String descripcion) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
