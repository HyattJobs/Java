//package javanext.util;
//
//
//public interface Map<K,V> {
//    /**
//     * Map 解释:查找表,我觉得翻译为映射更好一些
//     *
//     * 一个对象可以将键映射到值,一个映射不能包含多个键,每个键最多只能映射到一个值
//     *
//     * 这个借口替代了 Dictionary 类,是一个完全抽象的类,而不是接口
//     *
//     * 这个 Map 接口提供了3种集合视图,允许将映射的内容看做一组键值集合或者一组键值映射,
//     * 有序映射被定义为映射集合视图上的有序迭代器,返回他们.例如像 TreeMap 映射的实现,就利用了这个,
//     * 保证了他们特定的顺序,其他像 HashMap 并没有用到
//     *
//     * 注意: 如果将可变对象用作映射的键那就要非常小心了.
//     * 用一种对象在映射里作为键的方式做比较,对象的值改变了,映射的行为也会改变;( affects <tt>equals</tt> comparisons 翻译:影响相等比较)
//     * 也有特殊的例子,一个映射是不允许将他自己作为键的;当然,一个映射把它自己作为值是被允许的;
//     * 特别注意的是: equals和hashCode方法在这种映射里是不太良好的定义
//     *
//     * 通常映射的实现应该提供两个标准的构造函数:一个无参构造函数创建一个空映射,一个带单个参数类型的映射,
//     * 该映射创建一个带相同键值的映射作为他们的参数;实际上,后者允许用户复制任何映射,生成所需类的等效映射。
//     * 并不是强制执行这个建议(正如接口中不包含构造函数),但是所有在jdk中的映射已经实现
//     *
//     * 烂方法包含在这个接口中,那就是方法修改他们所操作的映射,当然,如果这个映射不支持这个操作,会抛出
//     * UnsupportedOperationException的异常,如果是这样,这些方法可能会这样,
//     * 如果调取不会影响到这个映射,不会抛出异常.
//     * 例如要调用一个不可改变的map的putAll方法,(如果这个要叠加的映射为空),就会抛出一个异常,但是这不需要
//     *
//     * 一些映射的实现在他们的键值上做了限制.例如:一些实现映射实现禁止空键和空值,一些则在他们的键的类型上做了限制,
//     * 尝试去插入不合法的键或值就会抛出未捕获的空指针或类型转换异常的异常.尝试去插入不合法的键或者值的时候,
//     * 通常会抛出空指针或者类型转换错误的异常.尝试去查询不合法的键或者值可能会抛出异常,或者它可能只是返回false.
//     * 一些实现将展示前一种行为,而另一些将展示后一种行为.一般来说,尝试操作一个不合法的键或者值,
//     * 如果该键或值得完成不会导致将不合法的元素插入到映射中,则可能抛出异常,或者根据实现的选项,该操作可能成功.
//     * 像这种异常在接口的规范中被标记为典型的.
//     *
//     * 此接口是 <a href="{@docRoot}/../technotes/guides/collections/index.html" /> 的集合框架
//     *
//     * 许多在集合框架接口中的方法被定义在 Object中. 例如,在{@link #containsKey(Object) containsKey(Object key)}
//     * 规范中的方法提到:返回 true,如果这个映射只包含一个 像 (key == null ? k == null:key.equals(k)) k 的键.
//     * 这个不应该被认为暗示调用一个非零参数的键去调用Map.containsKey导致对任何键k调用key.equals(k)
//     * 实现可以自由的优化,从而避免了equals的调用,例如,可以通过比较他们的哈希key的值,这个hashCode规定两个对象必须要有两个不相等的
//     * hash code, 通常,各种集合框架接口的实现可以自由的利用底层{@link Object}方法指定的行为,只要实现者认为合适
//     *
//     * <K>参数 映射包含键的类型
//     * <V>匹配值得类型
//     **/
//
//    /**
//     * 返回键值对在映射中的个数.如果映射包含键值对的个数超过了 整数的最大值,返回整数的最大值
//     * @return 返回键值对的在映射中的个数
//     */
//    int size();
//
//}
//
