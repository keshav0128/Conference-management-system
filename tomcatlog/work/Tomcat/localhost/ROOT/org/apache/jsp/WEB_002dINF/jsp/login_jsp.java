/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2023-03-22 00:51:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.io.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/C:/Users/Deepak%20Parashar/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("file:/C:/Users/Deepak%20Parashar/.m2/repository/org/springframework/spring-webmvc/5.1.3.RELEASE/spring-webmvc-5.1.3.RELEASE.jar", Long.valueOf(1588329221019L));
    _jspx_dependants.put("file:/C:/Users/Deepak%20Parashar/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1592300692560L));
    _jspx_dependants.put("jar:file:/C:/Users/Deepak%20Parashar/.m2/repository/org/springframework/spring-webmvc/5.1.3.RELEASE/spring-webmvc-5.1.3.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1543290104000L));
    _jspx_dependants.put("jar:file:/C:/Users/Deepak%20Parashar/.m2/repository/org/springframework/spring-webmvc/5.1.3.RELEASE/spring-webmvc-5.1.3.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1543290104000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("  \r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"\" href=\"css/bootstrap4.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Font Awesome CDN -->\r\n");
      out.write("    <!-- <script src=\"https://kit.fontawesome.com/23412c6a8d.js\"></script> -->\r\n");
      out.write("    <script src=\"js/fontawesome.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- css file cdn -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/login.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- jquery cdn -->\r\n");
      out.write("   <!-- DataTables script -->\r\n");
      out.write("\r\n");
      out.write("\t<Script src=\"js/jquery-3.5.1.min.js\"></Script>\r\n");
      out.write("    <Script src=\"js/jquery.validate.min.js\"></Script>\r\n");
      out.write("    <Script src=\"js/bootstrap.min.js\"></Script>\r\n");
      out.write("    <!-- js file link -->\r\n");
      out.write("    <script  type=\"text/javascript\" src=\"js/style.js\"></script>\r\n");
      out.write("    <script  src=\"js/bootstrap-password-toggler.min.js\"></script>   \r\n");
      out.write("\r\n");
      out.write("    <title>Conference Management System</title>\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("function forgetPassword(evt)\r\n");
      out.write("{\r\n");
      out.write("\t \r\n");
      out.write("     var loginId =  document.getElementById(\"loginId\").value;\r\n");
      out.write("     if (loginId ==\"\") {\r\n");
      out.write("    \t //alert (\"loginId is mandatory\")\r\n");
      out.write("    \tswal({\r\n");
      out.write("\t\t\t  //title: \"Good job!\",\r\n");
      out.write("\t\t\t  text: \"Please fill Login Id to get password\",\r\n");
      out.write("\t\t\t  icon: \"warning\",\r\n");
      out.write("\t\t\t  button: \"Ok\",\r\n");
      out.write("\t\t\t  //dangerMode: true\r\n");
      out.write("\t\t\t  closeOnClickOutside: false, // prevent close on click anywhere/outside\r\n");
      out.write("\t\t\t  showConfirmButton: false,\r\n");
      out.write("\t\t\t  allowOutsideClick: false,\r\n");
      out.write("\t\t\t  allowEscapeKey: false\r\n");
      out.write("\t\t });\r\n");
      out.write("    \t \r\n");
      out.write("    \tevt.preventDefault();\r\n");
      out.write("    \t return false;\r\n");
      out.write("    \t}\r\n");
      out.write("     \r\n");
      out.write("     /* var captcha =  document.getElementById(\"captcha\").value;\r\n");
      out.write("     if (captcha ==\"\") {\r\n");
      out.write("    \t //alert (\"captcha is mandatory\")\r\n");
      out.write("    \t swal({\r\n");
      out.write("\t\t\t  //title: \"Good job!\",\r\n");
      out.write("\t\t\t  text: \"Please fill captcha to get password\",\r\n");
      out.write("\t\t\t  icon: \"warning\",\r\n");
      out.write("\t\t\t  button: \"Ok\",\r\n");
      out.write("\t\t\t  //dangerMode: true\r\n");
      out.write("\t\t\t  closeOnClickOutside: false, // prevent close on click anywhere/outside\r\n");
      out.write("\t\t\t  showConfirmButton: false,\r\n");
      out.write("\t\t\t  allowOutsideClick: false,\r\n");
      out.write("\t\t\t  allowEscapeKey: false\r\n");
      out.write("\t\t });\r\n");
      out.write("    \t evt.preventDefault();\r\n");
      out.write("    \t return false;\r\n");
      out.write("    \t}*/\r\n");
      out.write("     \r\n");
      out.write("var loginRole =  document.getElementById(\"loginRole\").value;\r\n");
      out.write("     \r\n");
      out.write("     if (loginRole ==\"\") {\r\n");
      out.write("    \t //alert (\"loginId is mandatory\")\r\n");
      out.write("    \tswal({\r\n");
      out.write("\t\t\t  //title: \"Good job!\",\r\n");
      out.write("\t\t\t  text: \"Please fill Login As to get password\",\r\n");
      out.write("\t\t\t  icon: \"warning\",\r\n");
      out.write("\t\t\t  button: \"Ok\",\r\n");
      out.write("\t\t\t  //dangerMode: true\r\n");
      out.write("\t\t\t  closeOnClickOutside: false, // prevent close on click anywhere/outside\r\n");
      out.write("\t\t\t  showConfirmButton: false,\r\n");
      out.write("\t\t\t  allowOutsideClick: false,\r\n");
      out.write("\t\t\t  allowEscapeKey: false\r\n");
      out.write("\t\t });\r\n");
      out.write("    \t \r\n");
      out.write("    \tevt.preventDefault();\r\n");
      out.write("    \t return false;\r\n");
      out.write("    \t}\r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("     $('#loginId1').val(loginId);\r\n");
      out.write("    // $('#captcha1').val(captcha);\r\n");
      out.write("     $('#loginRole1').val(loginRole);\r\n");
      out.write("     $('#Forgotform').submit();\r\n");
      out.write("    \t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function back_block() {\r\n");
      out.write("\t\r\n");
      out.write("window.history.foward(-1)\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Response.ExpiresAbsolute = new Date();//DateTime.Now;\r\n");
      out.write("Response.Expires = 0;\r\n");
      out.write("Response.CacheControl = \"no-cache\";\r\n");
      out.write("</script>\r\n");
      out.write("  ");

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server

      out.write("\r\n");
      out.write("\r\n");
      out.write("  <body  onload=\"loadaptcha();\">\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write("  <div class=\"container-fluid px-1 px-md-2 px-lg-1 px-xl-2 py-2 m-auto\">\r\n");
      out.write("    <div class=\"card card0 border-0\">\r\n");
      out.write("        <div class=\"row d-flex\">\r\n");
      out.write("            <div class=\"col-lg-6\">\r\n");
      out.write("                <div class=\"card1 pb-5\">\r\n");
      out.write("                    <div class=\"row\"> <img src=\"images/logo.png\" class=\"logo\"> </div>\r\n");
      out.write("                    <div class=\"row px-3 justify-content-center mt-4 mb-5 border-line\"> <img src=\"images/login_training_img.jpg\" class=\"image\"> </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-6\">\r\n");
      out.write("                <div class=\"card2 card border-0 px-4 py-3\">\r\n");
      out.write("                    <div class=\"row mb-4 px-3\">\r\n");
      out.write("                        <!-- <h4 class=\"mb-0 mr-4 mt-2\">Sign In</h4> -->\r\n");
      out.write("                        <h4 class=\"mb-0 mr-4 \">Conference Management System</h4>\r\n");
      out.write("                       \r\n");
      out.write("                    </div>\r\n");
      out.write("                   \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <form  action=validLogin method=POST  id=\"login\" name=\"login\" class=\"needs-validation\" novalidate>\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- ================================= -->\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\t\t  ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <input type=\"hidden\" class=\"form-control form-control-sm\" name=\"mac\" id=\"mac\" placeholder=\"mac\" required>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"row px-3 mb-2\"> <label class=\"mb-1\">\r\n");
      out.write("                            <h6 class=\"mb-0 text-sm\">Login ID</h6>\r\n");
      out.write("                            <input type=\"hidden\" name=\"loginFrom\" id=\"loginFrom\"  value=\"login\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"loginRole\" id=\"loginRole\" value=\"1\" >\r\n");
      out.write("                        </label> <input class=\"form-control\" type=\"text\" name=\"loginId\" id=\"loginId\" placeholder=\"Enter Login Id\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required> </div>\r\n");
      out.write("                    <div class=\"row px-3 mb-2\"> \r\n");
      out.write("                        <label class=\"mb-1 col-12 pl-0\">\r\n");
      out.write("                            <h6 class=\"mb-0 text-sm\">Password</h6>\r\n");
      out.write("                        </label> \r\n");
      out.write("                        <div class=\"password_field\">\r\n");
      out.write("                           <input type=\"password\" class=\"form-control\" name=\"Password\" id=\"Password\" placeholder=\"Enter password\" required>\r\n");
      out.write("                           <span><i class=\"far fa-eye\" id=\"togglePassword\" onclick=\"showPassword()\"></i></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"row px-3 mb-2\">\r\n");
      out.write("\t                    \r\n");
      out.write("\t                    <!-- <div class=\"row px-3\" id=\"captchaImg\"> \r\n");
      out.write("\t                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/getCaptcha\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t                     <div class=\"row ml-1\" id=\"randomText\"></div>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t                     \t                     \t                     \r\n");
      out.write("\t                     <button class=\"btn btn-sm\" type=\"button\" id=\"reload\" name=\"reload\"><i class=\"fas fa-sync\"></i></button> \r\n");
      out.write("\t                     -->\r\n");
      out.write("\t                </div>     \r\n");
      out.write("                    \r\n");
      out.write("                    <!-- \r\n");
      out.write("                    <div class=\"row px-3 mb-4\"> \r\n");
      out.write("                       <label class=\"mb-1\">\r\n");
      out.write("                        </label> <input  class=\"form-control\" id=\"captcha\" name=\"captcha\" maxlength=10 placeholder=\"Captcha\" required autocomplete=\"off\"> \r\n");
      out.write("                    </div>\r\n");
      out.write("                     -->\r\n");
      out.write("                   \r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"row mb-3 px-0\"> \r\n");
      out.write("                      <div class=\"col-md-4\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-blue text-center sm:mx-auto\">Login</button> \r\n");
      out.write("                      </div> \r\n");
      out.write("                      <div class=\"col-md-8\">\r\n");
      out.write("                        <small class=\"font-weight-bold register_link mt-2\"><a href=\"javascript:forgetPassword()\" class=\"mb-0 text-sm text-success\">\r\n");
      out.write("                          Forgot Password?\r\n");
      out.write("                        </a></small>\r\n");
      out.write("                      </div>  \r\n");
      out.write("                    </div>\r\n");
      out.write("                 </form>\r\n");
      out.write("                 \r\n");
      out.write("                 <!-- ==========hidden input========== -->\r\n");
      out.write("                  <form action=forgetPassword method=POST id=\"Forgotform\" name=\"Forgotform\">\r\n");
      out.write("                     \r\n");
      out.write("                      <input type=\"hidden\" name=\"loginId1\" id=\"loginId1\" class=\"form-input\" required>\r\n");
      out.write("                      <input type=\"hidden\" name=\"captcha1\" id=\"captcha1\" class=\"form-input\" required>\r\n");
      out.write("                      <input type=\"hidden\" name=\"loginFrom\" id=\"loginFrom\"  value=\"login\">  \r\n");
      out.write("                     <input type=\"hidden\" name=\"loginRole1\" id=\"loginRole1\" value=\"1\" >\r\n");
      out.write("                             \r\n");
      out.write("                  </form>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"bg-blue py-2\">\r\n");
      out.write("            <div class=\"row px-3\"> <small class=\"ml-4 ml-sm-5 mb-2\">Copyright &copy; <script>document.write(new Date().getFullYear());</script>. All rights reserved by <a href=\"https://www.nism.ac.in/\" target=\"_blank\">National Institute Of Securities Markets</a></small>\r\n");
      out.write("              <!--    <div class=\"social-contact ml-4 ml-sm-auto\"> <span class=\"fa fa-facebook mr-4 text-sm\"></span> <span class=\"fa fa-google-plus mr-4 text-sm\"></span> <span class=\"fa fa-linkedin mr-4 text-sm\"></span> <span class=\"fa fa-twitter mr-4 mr-sm-5 text-sm\"></span> </div>-->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write(" /*\r\n");
      out.write("\tfunction loadaptcha(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("            url: 'getAYTCaptcha',\r\n");
      out.write("            type: 'get',\r\n");
      out.write("            cache: false,\r\n");
      out.write("            //dataType: 'image/jpeg',\r\n");
      out.write("            //data: {action: 'process'},\r\n");
      out.write("            success: function(data){\r\n");
      out.write("        \t\tdocument.getElementById('randomText').innerHTML = data;\r\n");
      out.write("    \t\t}\r\n");
      out.write("        });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    $(document).ready(function(){\r\n");
      out.write("        $(\"#reload\").click(function(){\r\n");
      out.write("        \t\r\n");
      out.write("        \t$.ajax({\r\n");
      out.write("                url: 'getAYTCaptcha',\r\n");
      out.write("                type: 'get',\r\n");
      out.write("                cache: false,\r\n");
      out.write("                //dataType: 'image/jpeg',\r\n");
      out.write("                //data: {action: 'process'},\r\n");
      out.write("                success: function(data){\r\n");
      out.write("            \t\tdocument.getElementById('randomText').innerHTML = data;\r\n");
      out.write("        \t\t}\r\n");
      out.write("            });\r\n");
      out.write("        \t\r\n");
      out.write("            //location.reload(true);\r\n");
      out.write("        });\r\n");
      out.write("    });*/\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("<script>\r\n");
      out.write("      // Example starter JavaScript for disabling form submissions if there are invalid fields\r\n");
      out.write("      (function() {\r\n");
      out.write("        'use strict';\r\n");
      out.write("        window.addEventListener('load', function() {\r\n");
      out.write("          // Fetch all the forms we want to apply custom Bootstrap validation styles to\r\n");
      out.write("          var forms = document.getElementsByClassName('needs-validation');\r\n");
      out.write("          // Loop over them and prevent submission\r\n");
      out.write("          var validation = Array.prototype.filter.call(forms, function(form) {\r\n");
      out.write("            form.addEventListener('submit', function(event) {\r\n");
      out.write("              if (form.checkValidity() === false) {\r\n");
      out.write("                event.preventDefault();\r\n");
      out.write("                event.stopPropagation();\r\n");
      out.write("              }\r\n");
      out.write("              form.classList.add('was-validated');\r\n");
      out.write("            }, false);\r\n");
      out.write("          });\r\n");
      out.write("        }, false);\r\n");
      out.write("      })();\r\n");
      out.write("      </script>\r\n");
      out.write("     <script>\r\n");
      out.write("    \r\n");
      out.write("\t$(document).ready(function () {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#login').validate({\r\n");
      out.write("\t\t    rules: {\r\n");
      out.write("\t\t    \t\r\n");
      out.write("\t\t        email: {\r\n");
      out.write("\t\t        \tminlength: 5,\r\n");
      out.write("\t\t        \tmaxlength: 200,\r\n");
      out.write("\t\t            email: true\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    errorElement: 'span',\r\n");
      out.write("\t        highlight: function(element, errorClass, validClass) {\r\n");
      out.write("\t            $(element).removeClass(validClass);\r\n");
      out.write("\t        },\r\n");
      out.write("\t        unhighlight: function(element, errorClass, validClass) {\r\n");
      out.write("\t            $(element).addClass(validClass);\r\n");
      out.write("\r\n");
      out.write("\t        },\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script> \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("  \r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function showPassword() {\r\n");
      out.write("\t  var x = document.getElementById(\"Password\");\r\n");
      out.write("\t  if (x.type === \"password\") {\r\n");
      out.write("\t    x.type = \"text\";\r\n");
      out.write("\t  } else {\r\n");
      out.write("\t    x.type = \"password\";\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/jsp/login.jsp(161,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${successMessage != null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t   ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${successMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t    <span aria-hidden=\"true\">&times;</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  </button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t </div>\r\n");
          out.write("\t\t\t\t\t\t\t ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/jsp/login.jsp(174,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage != null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t <div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t   \t     <span aria-hidden=\"true\">&times;</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t   </button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t  </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
