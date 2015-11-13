# SimpleRecyclerAdapter
universal RecyclerView adapter for android

### step 1
##### Gradle接入
```groovy
compile 'com.apkfuns.simplerecycleradapter:simplerecycleradapter:1.0'
```


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

## About
 * Blog: [apkfuns.com](http://apkfuns.com?from=github)
 * Email: [pengwei1024@gmail.com](http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=pengwei1024@gmail.com)
 
### Thanks
 thanks to [Mr.Simple](http://blog.csdn.net/bboyfeiyu/article/details/48806125)
 
### License
 <pre>
 Copyright 2015 Orhan Obut
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 </pre>

