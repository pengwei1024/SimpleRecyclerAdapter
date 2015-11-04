# SimpleRecyclerAdapter
universal RecyclerView adapter for android

### step 1
<a href='https://github.com/pengwei1024/SimpleRecyclerAdapter/blob/master/simplerecycleradapter/src/main/java/com/apkfuns/simplerecycleradapter/SimpleRecyclerAdapter.java' target='_blank'>下载SimpleRecyclerAdapter</a>

### step 2
创建adapter继承SimpleRecyclerAdapter
```java
class DemoAdapter extends SimpleRecyclerAdapter<Model> {

        public DemoAdapter(List<Model> list) {
            super(list);
        }

        // 设置布局文件
        @Override
        public int getLayoutRes() {
            return R.layout.adapter_demo;
        }

        // 绑定数据
        @Override
        public void onBindView(RVHolder holder, int position, Model entity) {
            SimpleDraweeView icon = holder.get(R.id.icon);
            icon.setImageURI(Uri.parse(entity.getImg()));
            holder.setTextView(R.id.name, entity.getName());
        }

        // itemClick事件监听
        @Override
        public void onItemClick(RVHolder holder, View view, int position, WelfareGridItem.ListEntity item) {
            Intent it = new Intent(getActivity(), MainActivity.class);
            getActivity().startActivity(it);
        }
    }
```  

### step 3
```java
recyclerView.setAdapter(new DemoAdapter(list));
```  

 
