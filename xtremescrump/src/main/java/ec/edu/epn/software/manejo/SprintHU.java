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
package ec.edu.epn.software.manejo;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Sprint;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author xavier
 */
public class SprintHU implements Serializable {

    private Sprint sprint;

    private List<HistoriaUsuario> historiaUsuarios;

    /**
     * Constructor vacio.
     */
    public SprintHU() {
    }

    /**
     * Constructor con parametros.
     *
     * @param sprint
     * @param historiaUsuarios
     */
    public SprintHU(Sprint sprint, List<HistoriaUsuario> historiaUsuarios) {
        this.sprint = sprint;
        this.historiaUsuarios = historiaUsuarios;
    }

    /**
     * @return the sprint
     */
    public Sprint getSprint() {
        return sprint;
    }

    /**
     * @param sprint the sprint to set
     */
    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    /**
     * @return the historiaUsuarios
     */
    public List<HistoriaUsuario> getHistoriaUsuarios() {
        return historiaUsuarios;
    }

    /**
     * @param historiaUsuarios the historiaUsuarios to set
     */
    public void setHistoriaUsuarios(List<HistoriaUsuario> historiaUsuarios) {
        this.historiaUsuarios = historiaUsuarios;
    }

}
