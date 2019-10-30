代码是一个很简单的乱码解决方案。


如果还遇到复杂的问题可以用以下方案

servlet中request和response都有一个装饰者基类wrapper

getParameterMap()可以获得变量Map,然后：

//按照字符通用编码进行打散，即进行编码
byte[] bytes = value[i].getBytes("ISO8859-1");
//按照目标编码进行组装，即进行解码
values[i] = new String(bytes,"UTF-8");
// Map<String, String[]> map = new HashMap<>();
// key 是原来getParameterMap中的key.
// 对原来的Map进行替换
map.put(key, values);