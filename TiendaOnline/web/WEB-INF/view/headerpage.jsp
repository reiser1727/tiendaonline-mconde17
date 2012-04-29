<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="top_bar">
        <div class="top_search">
            <div class="search_text"><a href="#">Buscar Producto:</a></div>
            <input type="text" class="search_input" name="search" />
            <input type="image" src="/images/search.gif" class="search_bt"/>
        </div>

        <div class="languages">
            <div class="lang_text">Idiomas:</div>
            <a href="#" class="lang"><img src="/images/es.gif" alt="" title="" border="0" /></a>      
        </div>

    </div>
    <div id="header">

        <div id="logo">
            <a href="/index.jsp"><img src="/images/logo.png" alt="" title="" 
                                     border="0" width="237" height="140" /></a>
        </div>

        <div class="oferte_content">
            <div class="top_divider"><img src="/images/header_divider.png" 
                                          alt="" title="" width="1" height="164" /></div>
            <div class="oferta">

                <div class="oferta_content">
                    <img src="/images/laptop.png" width="94" height="92" border="0" class="oferta_img" />

                    <div class="oferta_details">
                        <div class="oferta_title">Ordenador en Oferta</div>
                        <div class="oferta_text">
                            Esto parece que de momento funciona de forma decente xD
                        </div>
                        <a href="/webactions/productdetails.jsp" class="details">Detalles</a>
                    </div>
                </div>
                <div class="oferta_pagination">

                    <span class="current">1</span>
                    <a href="/WEB-INF/view/errors/error501.html">2</a>
                    <a href="/WEB-INF/view/errors/error501.html">3</a>
                    <a href="/WEB-INF/view/errors/error501.html">4</a>
                    <a href="/WEB-INF/view/errors/error501.html">5</a>  

                </div>        

            </div>
            <div class="top_divider"><img src="/images/header_divider.png" 
                                          alt="" title="" width="1" height="164" /></div>
        </div> <!-- end of oferte_content-->

    </div>
</html>
