package ro2;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchIconItem;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends b implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    private View f431813i;

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<TextView> f431814m = new SparseArray<>();
    private final SparseArray<View> C = new SparseArray<>();

    @Override // ro2.b
    public void d(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp, int i3, int i16) {
        super.d(headTemplatePB$SearchTemplateResp, i3, i16);
        this.f431813i.setVisibility(8);
        List<HeadTemplatePB$SearchIconItem> list = headTemplatePB$SearchTemplateResp.icons.get();
        if (list.isEmpty()) {
            this.f431806f = true;
            return;
        }
        if (!list.get(0).icon.get().isEmpty()) {
            this.f431806f = true;
            return;
        }
        if (list.size() > 4) {
            list = list.subList(0, 4);
        }
        int size = this.C.size();
        for (int i17 = 0; i17 < size; i17++) {
            this.C.valueAt(i17).setVisibility(8);
        }
        int size2 = this.f431814m.size();
        for (int i18 = 0; i18 < size2; i18++) {
            this.f431814m.valueAt(i18).setVisibility(8);
        }
        this.f431813i.setVisibility(0);
        this.f431806f = false;
        int size3 = list.size();
        for (int i19 = 0; i19 < size3; i19++) {
            HeadTemplatePB$SearchIconItem headTemplatePB$SearchIconItem = list.get(i19);
            TextView textView = this.f431814m.get(i19);
            if (textView != null) {
                textView.setText(headTemplatePB$SearchIconItem.text.get());
                textView.setVisibility(0);
                textView.setOnClickListener(this);
                textView.setTag(headTemplatePB$SearchIconItem.scheme.get());
                so2.a.a(textView, headTemplatePB$SearchIconItem.report_info.get(), i16);
            }
            View view = this.C.get(i19);
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    @Override // ro2.b
    public void e(View view) {
        super.e(view);
        this.f431813i = view.findViewById(R.id.f53302c5);
        TextView textView = (TextView) view.findViewById(R.id.f53262c1);
        TextView textView2 = (TextView) view.findViewById(R.id.f53272c2);
        TextView textView3 = (TextView) view.findViewById(R.id.f53282c3);
        TextView textView4 = (TextView) view.findViewById(R.id.f53292c4);
        this.f431814m.put(0, textView);
        this.f431814m.put(1, textView2);
        this.f431814m.put(2, textView3);
        this.f431814m.put(3, textView4);
        View findViewById = view.findViewById(R.id.f53232by);
        View findViewById2 = view.findViewById(R.id.f53242bz);
        View findViewById3 = view.findViewById(R.id.f53252c0);
        this.C.put(1, findViewById);
        this.C.put(2, findViewById2);
        this.C.put(3, findViewById3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag instanceof String) {
            a("QCircleSearchGameUnionTextLinkPresenter", (String) tag);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
