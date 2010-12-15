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
package org.moqui.context;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.ext.servlet.HttpSessionHashModel;
import freemarker.ext.servlet.ServletContextHashModel;

/**
 * Interface definition for object used throughout the Moqui Framework to manage contextual execution information and tool interfaces.
 */
public interface WebExecutionContext extends ExecutionContext {
    Map<String, Object> getParameters();

    HttpServletRequest getRequest();
    HttpRequestHashModel getRequestAttributes();
    Map<String, ?> getRequestParameters();

    HttpServletResponse getResponse();

    HttpSession getSession();
    HttpSessionHashModel getSessionAttributes();

    ServletContext getServletContext();
    ServletContextHashModel getApplicationAttributes();
}