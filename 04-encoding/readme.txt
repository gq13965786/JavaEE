������һ���ܼ򵥵�������������


������������ӵ�������������·���

servlet��request��response����һ��װ���߻���wrapper

getParameterMap()���Ի�ñ���Map,Ȼ��

//�����ַ�ͨ�ñ�����д�ɢ�������б���
byte[] bytes = value[i].getBytes("ISO8859-1");
//����Ŀ����������װ�������н���
values[i] = new String(bytes,"UTF-8");
// Map<String, String[]> map = new HashMap<>();
// key ��ԭ��getParameterMap�е�key.
// ��ԭ����Map�����滻
map.put(key, values);