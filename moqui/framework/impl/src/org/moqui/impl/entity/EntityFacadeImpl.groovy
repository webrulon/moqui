/*
 * This Work is in the public domain and is provided on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE,
 * NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 * You are solely responsible for determining the appropriateness of using
 * this Work and assume any risks associated with your use of this Work.
 *
 * This Work includes contributions authored by David E. Jones, not as a
 * "work for hire", who hereby disclaims any copyright to the same.
 */
package org.moqui.impl.entity

import org.moqui.entity.EntityFacade
import org.moqui.entity.EntityConditionFactory
import org.moqui.entity.EntityValue
import org.moqui.entity.EntityCondition
import org.moqui.entity.EntityFind
import java.sql.Connection
import org.moqui.entity.EntityList
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.moqui.impl.context.ExecutionContextFactoryImpl

class EntityFacadeImpl implements EntityFacade {

    protected final ExecutionContextFactoryImpl ecfi

    protected final EntityConditionFactoryImpl entityConditionFactory

    EntityFacadeImpl(ExecutionContextFactoryImpl ecfi) {
        this.ecfi = ecfi
        this.entityConditionFactory = new EntityConditionFactoryImpl(this)

        // TODO: init connection pool
        // TODO: init entity definitions
        // TODO: EECA rule tables
    }

    void destroy() {
        // TODO: destroy connection pool, etc
    }

    EntityDefinition getEntityDefinition(String entityName) {
        // TODO: implement this
        return null
    }

    Node getDatabaseNode(String entityName) {
        def confXmlRoot = this.ecfi.getConfXmlRoot()
        def databaseConfName = getDataBaseConfName(entityName)
        return (Node) confXmlRoot."database-list".database.find({ it.@name == databaseConfName })[0]
    }
    String getDataBaseConfName(String entityName) {
        String groupName = this.getEntityGroupName(entityName)
        def confXmlRoot = this.ecfi.getConfXmlRoot()
        def datasourceNode = confXmlRoot."entity-facade".datasource.find({ it."@group-name" == groupName })
        return datasourceNode."@database-conf-name"
    }

    // ========== Interface Implementations ==========

    /** @see org.moqui.entity.EntityFacade#getConditionFactory() */
    EntityConditionFactory getConditionFactory() {
        return this.entityConditionFactory
    }

    /** @see org.moqui.entity.EntityFacade#makeValue(Element) */
    EntityValue makeValue(String entityName) {
        // TODO: implement this
        return null
    }

    /** @see org.moqui.entity.EntityFacade#updateByCondition(String, Map<String,?>, EntityCondition) */
    int updateByCondition(String entityName, Map<String, ?> fieldsToSet, EntityCondition condition) {
        // TODO: implement this
        return 0
    }

    /** @see org.moqui.entity.EntityFacade#deleteByCondition(String, EntityCondition) */
    int deleteByCondition(String entityName, EntityCondition condition) {
        // TODO: implement this
        return 0
    }

    /** @see org.moqui.entity.EntityFacade#find(String) */
    EntityFind find(String entityName) {
        return new EntityFindImpl(this, entityName)
    }

    /** @see org.moqui.entity.EntityFacade#sequencedIdPrimary(String, long) */
    String sequencedIdPrimary(String seqName, Long staggerMax) {
        // TODO: implement this
        return null
    }

    /** @see org.moqui.entity.EntityFacade#sequencedIdSecondary(EntityValue, String, int, int) */
    void sequencedIdSecondary(EntityValue value, String seqFieldName, Integer numericPadding, Integer incrementBy) {
        // TODO: implement this
    }

    /** @see org.moqui.entity.EntityFacade#getEntityGroupName(String) */
    String getEntityGroupName(String entityName) {
        // TODO: implement this
        return null
    }

    /** @see org.moqui.entity.EntityFacade#getConnection(String) */
    Connection getConnection(String groupName) {
        // TODO: implement this
        return null
    }

    /** @see org.moqui.entity.EntityFacade#readXmlDocument(URL) */
    EntityList readXmlDocument(URL url) {
        // TODO: implement this
        return null
    }

    /** @see org.moqui.entity.EntityFacade#readXmlDocument(Document) */
    EntityList readXmlDocument(Document document) {
        // TODO: implement this
        return null
    }

    /** @see org.moqui.entity.EntityFacade#makeValue(Element) */
    EntityValue makeValue(Element element) {
        // TODO: implement this
        return null
    }
}