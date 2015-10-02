 
      var xmlHttp ; 
      var xmlHttp1 ; 
      
      function showAid(str){
      if (typeof XMLHttpRequest != "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request");
      return;
      } 
      var url="aid.jsp";
      url +="?pro=" +str;
      xmlHttp.onreadystatechange = stateChange;
      xmlHttp.open("get", url, true);
      xmlHttp.send(null);
      }
      function showBrand(str){
          if (typeof XMLHttpRequest != "undefined"){
          xmlHttp1= new XMLHttpRequest();
          }
          else if (window.ActiveXObject){
          xmlHttp1= new ActiveXObject("Microsoft.XMLHTTP");
          }
          if (xmlHttp1==null){
          alert("Browser does not support XMLHTTP Request");
          return;
          } 
          var url="brand.jsp";
          url +="?pro=" +str;
          xmlHttp1.onreadystatechange = stateChange1;
          xmlHttp1.open("get", url, true);
          xmlHttp1.send(null);
          }
      function stateChange(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("aid").innerHTML=xmlHttp.responseText;   
      }   
      }
      function stateChange1(){   
          if (xmlHttp1.readyState==4 || xmlHttp1.readyState=="complete"){   
          document.getElementById("br").innerHTML=xmlHttp1.responseText;   
          }   
          }
      
