/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.jsonPostgreSQL;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.sql.Types;
import org.hibernate.dialect.PostgreSQL95Dialect;

/**
 *
 * @author Andy
 */
public class PostgreSQL95JsonDialect extends PostgreSQL95Dialect {
    public PostgreSQL95JsonDialect() {
        super();
        this.registerHibernateType(Types.OTHER, JsonStringType.class.getName());
        this.registerHibernateType(Types.OTHER, JsonBinaryType.class.getName());
        this.registerHibernateType(Types.OTHER, JsonNodeBinaryType.class.getName());
        this.registerHibernateType(Types.OTHER, JsonNodeStringType.class.getName());
    }
}
