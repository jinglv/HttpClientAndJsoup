# Java进行接口测试
- jsoup
- httpClient

## jsoup
jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。

### jsoup的主要功能如下
1. 从一个URL，文件或字符串中解析HTML；
2. 使用DOM或CSS选择器来查找、取出数据；
3. 可操作HTML元素、属性、文本；

### JSoup应用的主要类
虽然完整的类库中有很多类，但大多数情况下，下面给出3个类是需要重点了解的。

**1. org.jsoup.Jsoup类**

Jsoup类是任何Jsoup程序的入口点，并将提供从各种来源加载和解析HTML文档的方法。

Jsoup类的一些重要方法如下：
<table>
<thead>
<tr>
<th>方法</th>
<th>描述</th>
</tr>
</thead>
<tbody>
<tr>
<td><code>static Connection connect(String url)</code></td>
<td>创建并返回URL的连接。</td>
</tr>
<tr>
<td><code>static Document parse(File in, String charsetName)</code></td>
<td>将指定的字符集文件解析成文档。</td>
</tr>
<tr>
<td><code>static Document parse(String html)</code></td>
<td>将给定的html代码解析成文档。</td>
</tr>
<tr>
<td><code>static String clean(String bodyHtml, Whitelist whitelist)</code></td>
<td>从输入HTML返回安全的HTML，通过解析输入HTML并通过允许的标签和属性的白名单进行过滤。</td>
</tr>
</tbody>
</table>

**2. org.jsoup.nodes.Document类**

该类表示通过Jsoup库加载HTML文档。可以使用此类执行适用于整个HTML文档的操作。
Element类的重要方法可以参见 - http://jsoup.org/apidocs/org/jsoup/nodes/Document.html 。

**3. org.jsoup.nodes.Element类**

HTML元素是由标签名称，属性和子节点组成。 使用Element类，您可以提取数据，遍历节点和操作HTML。
Element类的重要方法可参见 - http://jsoup.org/apidocs/org/jsoup/nodes/Element.html 。


