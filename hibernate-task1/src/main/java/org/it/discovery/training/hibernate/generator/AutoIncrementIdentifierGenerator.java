package org.it.discovery.training.hibernate.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class AutoIncrementIdentifierGenerator implements IdentifierGenerator {
    private int counter = 10;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return counter++;
    }
}
