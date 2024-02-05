/*
 * Copyright (c) 2004-2023, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.hisp.dhis.integration.esavi.converters.v1;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.BooleanType;

import static org.springframework.util.StringUtils.hasText;

public class EsaviRespuestaSimple
{
    private static String SYSTEM = "https://paho.org/fhir/esavi/CodeSystem/RespuestaSiNoNosabeCS";

    public static Coding get( String value )
    {
        switch ( value )
        {
        case "1":
            return new Coding( SYSTEM, "1", "Si" );
        case "2":
            return new Coding( SYSTEM, "2", "No" );
        case "3":
            return new Coding( SYSTEM, "3", "No sabe" );
        default:
            return null;
        }
    }

    public static Coding fromBoolean( boolean value )
    {
        if (value == true) {
            return new Coding(SYSTEM, "1", "Si");
        } else {
            return new Coding( SYSTEM, "2", "No" );
        }
    }

    public static BooleanType getBoolean( String value )
    {
        switch ( value )
        {
            case "1":
                return new BooleanType(true);
            case "2":
                return new BooleanType(false);
            case "3":
                return null; // TODO mapping pending
            default:
                return null;
        }
    }

    private EsaviRespuestaSimple()
    {

    }
}
