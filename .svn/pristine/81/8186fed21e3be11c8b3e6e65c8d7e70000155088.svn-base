<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/index.min.js"></script>
</head>
<body>
<div id="box">
    <h2>房贷计算器</h2>
    <div id="tabs">
        <div id="content">
            <div id="contact">
                <form id="myform" action="#" style="display: block">
                    <div id="contact_left">
                        <div id="dklx">
                            <h5>请您填写:</h5>
                          	  贷款类别:
                            <label><input type="radio" name="dktype" checked value="0"/>商业贷款</label>
                            <label><input type="radio" name="dktype" value="1"/>公积金贷款</label>
                        </div>
                        <div id="jsfs">
                            <h6>计算方式:</h6>
                            <dl id="way">
                                <dt><label class="count"><input type="radio" name="jsfs" value="0" checked/>根据面积、单价计算</label></dt>
                                <dd style="display: block">
                                    <label>单价:</label><input type="text" name="price">元/平米<br>
                                    <label>面积:</label><input type="text" name="area">平方米<br>
                                    <label>按揭成数</label>
                                    <select class="form-control" name="ajcs">
                                        <option value="50">5成</option>
                                        <option value="60">6成</option>
                                        <option value="70" selected>7成</option>
                                        <option value="80">8成</option>
                                        <option value="90">9成</option>
                                    </select>
                                </dd>
                                <dt><label><input type="radio" value="1" name="jsfs"/>根据贷款总额计算</label></dt>
                                <dd>
                                    <label>贷款总额：<input type="text" name="dkze">元</label>
                                </dd>
                            </dl>
                            <label>按揭年数</label>
                            <select class="form-control" name="ajns">
                            	<option value="60" >5年（60期）</option>
                                <option value="120" selected>10年（120期）</option>
                                <option value="180">15年（180期）</option>
                                <option value="240">20年（240期）</option>
                                <option value="360">30年（360期）</option>
                            </select><br>
                        </div>
                        <div id="dkll">
                            <label>贷款利率</label>
                            <select name="dkll">
                                <option value="0">2017年08月01日利率下限(1.1倍)</option>
                                <option value="1">2017年08月01日利率下限(85折)</option>
                                <option value="2">2017年08月01日利率下限(7折)</option>
                                <option value="3" selected>2017年08月01日基准利率</option>
                            </select><br>
                            <input class="percent" name="dkll" type="text" value="4.90"/>%
                        </div>
                        <div id="method">
                        	    还款方式:
                            <label><input type="radio" name="bb" checked value="debx"/>等额本息</label>
                            <label><input type="radio" name="bb" value="debj"/>等额本金<br></label>
                        </div>
                        <input type="button" name="startCalc" class="start" value="开始计算"/>
                        <input type="reset" class="again" value="清空数据"/>
                    </div>
                    <div id="contact_right">
                        <h5>查看结果:</h5>
                        <label>房款总额:</label><input type="text" name="fousex" readonly/>元<br>
                        <label>贷款总额:</label><input type="text" name="loan" readonly/>元<br>
                        <label>还款总额:</label><input type="text" name="refund" readonly/>元<br>
                        <label>首期付款:</label><input type="text" name="first" readonly/>元<br>
                        <label>贷款月数:</label><input type="text" name="month" readonly/>月<br>
                        <label>支付利息:</label><input type="text" name="pay" readonly/>元<br>
                        <div id="debx"><label>月均还款:</label><input type="text" name="average" readonly/>元<br></div>
                        <div id="debj" style="display: none;"><label>月均还款:</label><textarea rows="10" cols="30" name="average" readonly></textarea>元<br></div>
                        <p style="color：red;">*以上结果仅供参考</p>
                    </div>
                </form>
            </div>
        </div>
    </div> 
</div>
</body>
</html>