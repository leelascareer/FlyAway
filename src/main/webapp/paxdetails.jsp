<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.flyaway.util.PaxUtil"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PASSENGER DETAILS</title>
</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	%>
	<b>Logged in User: <%= username%></b>
	<br>
	<br>
	<%
	String str_pax = (String) session.getAttribute("noofpax");
	
	//String str_pax = (String)request.getParameter("noofpax");
	//int pax = Integer.parseInt((String) request.getParameter("noofpax"));
	int pax=Integer.parseInt(str_pax);%>
	
	
	
	
	<%
	List<PaxUtil> paxList = new ArrayList<PaxUtil>();
	%>

	<form action="PaxDetails" method="post">
		<c:forEach var="i" begin="1" end="<%=pax%>" step="1">
			<div>

				<center>
					<b>Enter details for Passenger ${i}</b>
				</center>
				<br> First Name: <input type=text name="firstname" required="true"> 

					Last Name: <input type=text name="lastname" required="true"> 
					
					Age: <select name="age"
					id="age" required="true">
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35/option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					<option value="49">49</option>
					<option value="50">50</option>
					<option value="51">51</option>
					<option value="52">52</option>
					<option value="53">53</option>
					<option value="54">54</option>
					<option value="55">55</option>
					<option value="56">56</option>
					<option value="57">57</option>
					<option value="58">58</option>
					<option value="59">59</option>
					<option value="60">60</option>
					<option value="61">61</option>
					<option value="62">62</option>
					<option value="63">63</option>
					<option value="64">64</option>
					<option value="65">65</option>
					<option value="66">66</option>
					<option value="67">67</option>
					<option value="68">68</option>
					<option value="69">69</option>
					<option value="70">70</option>
					<option value="71">71</option>
					<option value="72">72</option>
					<option value="73">73</option>
					<option value="74">74</option>
					<option value="75">75</option>
					<option value="76">76</option>
					<option value="77">77</option>
					<option value="78">78</option>
					<option value="79">79</option>
					<option value="80">80</option>
					<option value="81">81</option>
					<option value="82">82</option>
					<option value="83">83</option>
					<option value="84">84</option>
					<option value="85">85</option>
					<option value="86">86</option>
					<option value="87">87</option>
					<option value="88">88</option>
					<option value="89">89</option>
					<option value="90">90</option>
					<option value="91">91</option>
					<option value="92">92</option>
					<option value="93">93</option>
					<option value="94">94</option>
					<option value="95">95</option>
					<option value="96">96</option>
					<option value="97">97</option>
					<option value="98">98</option>
					<option value="99">99</option>
					<option value="100">100</option>
				</select> Govt ID Proof: <input type=text name="govId" required="true">

				<input type="tel" id="phone" name="phone" pattern="[0-9]{10}"
					placeholder="10 digit mobile no" required> <br>

			</div>
			<br>
</c:forEach>
			<center>
			<div  style="width:150px; height:100px; background-color:blue; margin-bottom:10px" align="center">
				<h2> PAYMENT DETAILS SECTION</h2>			
			</div>
			<input type="submit" value="Pay Now" name="proceedToPay" />
			<div style="margin-top:10px"> <a href="homepage.jsp"> Back to Flight Search</a>
	</div>
		</center>
	</form>
	<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>