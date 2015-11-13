# SimpleRecyclerAdapter
universal RecyclerView adapter for android

### step 1
##### Gradle接入
```groovy
compile 'com.apkfuns.simplerecycleradapter:simplerecycleradapter:1.6'
```


### step 2
#### 简单用法
```java
recyclerView.setAdapter(new SimpleRecyclerAdapter<String>(R.layout.view_text,
                new String[]{"1", "2", "3", "4"}) {
            @Override
            public void onBindView(RVHolder holder, int position, int itemViewType, String o) {
                holder.setTextView(R.id.text, o);
            }
        });
```

更多构造方法支持
```java
recyclerView.setAdapter(new SimpleRecyclerAdapter<String>() {
            @Override
            public String[] getDataArray() {
                return new String[]{"1", "2", "3", "4"};
            }

            @Override
            public int getLayoutRes() {
                return R.layout.view_text;
            }

            @Override
            public void onBindView(RVHolder holder, int position, int itemViewType, String o) {
                holder.setTextView(R.id.text, o);
            }
        });
```

#### 复杂布局和数据
```java
// 数据结构
public class DemoModel {
    public String name;
    public int stuId;
    public int ClassId;
    public List<Subject> list;

    public class Subject{
        String subjectName;
        float score;
    }
}

// 创建adapter继承SimpleRecyclerAdapter
public class DemoAdapter extends SimpleRecyclerAdapter<DemoModel.Subject> {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_DEFAULT_LIST = 2;
    private static final int TYPE_FOOTER = 3;

    private DemoModel demoModel;

    public DemoAdapter(DemoModel demoModel) {
        super(demoModel.getList());
        this.demoModel = demoModel;
    }

    // 列表用的布局
    @Override
    public int getLayoutRes() {
        return R.layout.view_text;
    }

    // 数据类型
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
        return TYPE_DEFAULT_LIST;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return createRVHolder(parent, R.layout.view_demo_header);
            case TYPE_FOOTER:
                TextView footView = new TextView(parent.getContext());
                footView.setText("footer");
                return createRVHolder(footView);
            default:
                return createRVHolder(parent, getLayoutRes());
        }
    }

    @Override
    public void onBindView(RVHolder holder, int position, int itemViewType, DemoModel.Subject subject) {
        if (itemViewType == TYPE_HEADER) {
            holder.setTextView(R.id.header_text, demoModel.getName());
        } else if (itemViewType == TYPE_FOOTER) {
            TextView footerView = (TextView) holder.itemView;
            footerView.setText("footer view");
        } else {
            holder.setTextView(R.id.text, subject.subjectName + subject.score);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 这里处理item的事件
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        // list长度 + header + footer
        return super.getItemCount() + 2;
    }
}
```

##### 事件监听
* 重写adapter中onItemClick()方法
```java
@Override
public void onItemClick(RVHolder holder, View view, int position, Object item) {
   super.onItemClick(holder, view, position, item);
}
```
* 通过setOnItemClickListener()方法实现监听
```java
adapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, View view, int position, Object item) {
            }
});
```

#### 自定义事件
在onBindView()中实现自定义事件
```java
public void onBindView(RVHolder holder, int position, String s) {
            holder.itemView.setOnLongClickListener(null);
        }
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

