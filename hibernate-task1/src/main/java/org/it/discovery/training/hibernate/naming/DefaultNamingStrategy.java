package org.it.discovery.training.hibernate.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class DefaultNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(convertName(name.getText()));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(convertName(name.getText()));
    }

    private String convertName(String name) {
        StringBuilder builder = new StringBuilder(name.length());
        boolean skipConversion = false;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (Character.isUpperCase(ch) && i != 0 && !skipConversion) {
                builder.append("_");
            }
            builder.append(Character.toUpperCase(ch));
            if(!skipConversion) {
                skipConversion = ch == '_';
            }
        }

        return builder.toString();
    }
}
