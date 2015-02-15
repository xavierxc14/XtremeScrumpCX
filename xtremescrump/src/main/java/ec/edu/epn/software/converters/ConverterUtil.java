/*
 * Copyright (C) 2015 xavier
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ec.edu.epn.software.converters;

import ec.edu.epn.software.servicios.ServicioBase;
import java.lang.reflect.ParameterizedType;
import javax.faces.convert.ConverterException;

/**
 *
 * @author xavier
 */
//public final class ConverterUtil<Entidad, Servicio extends ServicioBase> {
//
//    /**
//     * Clase generica del DAO.
//     */
//    private final Class<Entidad> entidad;
//    private final Class<Servicio> servicio;
//
//    public ConverterUtil() {
//        final Class<Entidad> entity = (Class<Entidad>) ((ParameterizedType) this.getClass().getGenericSuperclass()).
//                getActualTypeArguments()[0];
//        this.entidad = entity;
//        final Class<Servicio> service = (Class<Servicio>) ((ParameterizedType) this.getClass().getGenericSuperclass()).
//                getActualTypeArguments()[1];
//        this.servicio = service;
//        //this.entityName = persistentVOClass.getSimpleName();
//    }
//
//    public Entidad getAsObject(Servicio service, Class<T> returnType, String value) {
//
//        if (returnType == null) {
//            throw new NullPointerException("Trying to getAsObject with a null return type.");
//        }
//        if (value == null) {
//            throw new NullPointerException("Trying to getAsObject with a null value.");
//        }
//        Integer id = null;
//        try {
//            id = Integer.parseInt(value);
//        } catch (NumberFormatException e) {
//            throw new ConverterException("Trying to getAsObject with a wrong id format.");
//        }
//        Entidad resultado = (Entidad) service.buscarPorId(id);
//        return resultado;
//    }
//
//    public String getAsString(Object value, ) {
//        
//        if (value instanceof ) {
//            Entidad resultado = (Entidad) value;
//            return String.valueOf(resultado.getId());
//        }
//    }
//
//}
