<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product}</title>
</head>
<body>
<p>
    <!-- TradingView Widget BEGIN -->
<div class="tradingview-widget-container">
    <div id="tradingview_ca812"></div>
    <div class="tradingview-widget-copyright"><a
            href="https://www.tradingview.com/symbols/${fromCurrency}${toCurrency}/" rel="noopener"
            target="_blank"><span class="blue-text">${fromCurrency}${toCurrency} chart</span></a> by TradingView
    </div>
    <script type="text/javascript" src="https://s3.tradingview.com/tv.js"></script>
    <script type="text/javascript">
        new TradingView.widget(
            {
                "width": 780,
                "height": 510,
                "symbol": "${fromCurrency}${toCurrency}",
                "interval": "D",
                "timezone": "Etc/UTC",
                "theme": "Light",
                "style": "1",
                "locale": "en",
                "toolbar_bg": "#f1f3f6",
                "enable_publishing": false,
                "hide_side_toolbar": false,
                "allow_symbol_change": true,
                "details": true,
                "news": [
                    "headlines"
                ],
                "container_id": "tradingview_ca812"
            }
        );
    </script>
</div>
<div class="center">
    <!-- TradingView Widget END -->
    Price: ${price} </br>
    Product: ${fromCurrency} / ${toCurrency}</br>
    </br>
    <form method="post" action="buyProduct">
        <input type="number" name="quantity" value="${quantity}" step="0.01">
        <input type="hidden" name="price" value="${price}"/>
        <input type="hidden" name="product" value="${product}"/>
        <input type="hidden" name="fromCurrency" value="${fromCurrency}"/>
        <input type="hidden" name="toCurrency" value="${toCurrency}"/>
        <input type="submit" name="buyButton" value="Buy"/><
    </form>
    <form method="post" action="sellProduct">
        <input type="submit" name="sellButton" value="Sell"/>
    </form>
</div>
</p>

</body>
</html>
