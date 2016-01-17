<%@ attribute name="fieldsTable"  type="java.util.List" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="fieldsTableTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--Dinamic data--%>
<%--group of fields--%>
<c:forEach var="groupItem" items="${fieldsTable}">

    <div class="panel panel-default" style="padding: 12pt; background-color: #e2e2e2">
            <%--fields inside group--%>
        <c:forEach var="keyValue" items="${groupItem.keySet()}">
            <%--table element--%>
            <c:if test="${groupItem.get(keyValue).getFieldType()==FieldAttribute.TABLE_INPUT}">
                <%--recursion call--%>
                <fieldsTableTag:fieldsTable fieldsTable="${groupItem.get(keyValue).getEmbededTable()}"/>
            </c:if>
            <%--ordinar input element--%>
            <c:if test="${groupItem.get(keyValue).getFieldType()==FieldAttribute.SIMPLE_INPUT}">
                <div class="form-group" style="visibility: ${groupItem.get(keyValue).isVisibility()}">
                    <label>
                            ${groupItem.get(keyValue).getFieldCaptionName()}:
                    </label>
                    <input type="text" class="form-control" id="${keyValue}"
                           maxlength="${groupItem.get(keyValue).getLength()}"
                           name="${keyValue}"
                           value="${groupItem.get(keyValue).getFieldValue()}"/>
                </div>
            </c:if>
            <%--calendar input--%>
            <c:if test="${groupItem.get(keyValue).getFieldType()==FieldAttribute.CALENDAR_INPUT}">
                <div class="form-group" style="visibility: ${groupItem.get(keyValue).isVisibility()}">
                    <label>
                            ${groupItem.get(keyValue).getFieldCaptionName()}:
                    </label>
                    <div class='input-group date' id='${keyValue}date'>
                        <input type="text" class="form-control" id="${keyValue}"
                               maxlength="${groupItem.get(keyValue).getLength()}"
                               name="${keyValue}"
                               value="${groupItem.get(keyValue).getFieldValue()}"/>
                    <span class="input-group-addon">
                         <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
            </c:if>

            <%--Radio input--%>
            <c:if test="${groupItem.get(keyValue).getFieldType()==FieldAttribute.RADIO_INPUT}">
                <div class="form-group" style="visibility: ${groupItem.get(keyValue).isVisibility()}">
                    <label>
                            ${groupItem.get(keyValue).getFieldCaptionName()}:
                    </label>
                    <c:forEach var="radioValue" items="${groupItem.get(keyValue).getFieldValueList()}">
                        <label class="radio-inline" style="visibility: ${groupItem.get(keyValue).isVisibility()}">
                            <input type="radio" name="${keyValue}">${radioValue}
                        </label>
                    </c:forEach>
                </div>
            </c:if>

            <%--CheckBox input--%>
            <c:if test="${groupItem.get(keyValue).getFieldType()==FieldAttribute.CHECKBOX_INPUT}">
                <div class="form-group" style="visibility: ${groupItem.get(keyValue).isVisibility()}">
                    <label>
                            ${groupItem.get(keyValue).getFieldCaptionName()}:
                    </label>
                    <c:forEach var="checkValue" items="${groupItem.get(keyValue).getFieldValueList()}">
                        <div class="checkbox">
                            <label><input type="checkbox" value="" name="${keyValue}">${checkValue}</label>
                        </div>
                    </c:forEach>
                </div>
            </c:if>

            <%--lov input--%>
            <c:if test="${groupItem.get(keyValue).getFieldType()==FieldAttribute.LOV_INPUT}">
                <div class="form-group" style="visibility: ${groupItem.get(keyValue).isVisibility()}">
                    <label>
                            ${groupItem.get(keyValue).getFieldCaptionName()}:
                    </label>
                    <select class="form-control" id="${keyValue}">
                        <c:forEach var="lovValue" items="${groupItem.get(keyValue).getFieldValueList()}">
                            <option>${lovValue}</option>
                        </c:forEach>
                    </select>
                </div>
            </c:if>

        </c:forEach>
    </div>
</c:forEach>