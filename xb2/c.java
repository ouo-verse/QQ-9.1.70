package xb2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.now.message.WrapperArkView;
import com.tencent.mobileqq.qqlive.api.msg.IQQLiveMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private BaseActivity f447754d;

    /* renamed from: e, reason: collision with root package name */
    private List<MsgRecord> f447755e;

    /* renamed from: f, reason: collision with root package name */
    private List<WrapperArkView> f447756f = new ArrayList();

    public c(BaseActivity baseActivity) {
        this.f447754d = baseActivity;
    }

    private View e(final Context context, final MsgRecord msgRecord, final int i3) {
        WrapperArkView wrapperArkView = new WrapperArkView(context, msgRecord);
        wrapperArkView.setOnClickListener(new View.OnClickListener() { // from class: xb2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.i(i3, msgRecord, context, view);
            }
        });
        return wrapperArkView;
    }

    private View g(@NonNull ViewGroup viewGroup) {
        return LayoutInflater.from(this.f447754d).inflate(R.layout.fpk, viewGroup, false);
    }

    private View h(ViewGroup viewGroup, int i3) {
        if (i3 >= getF373114d()) {
            i3 = 0;
        }
        if (i3 == 4) {
            return g(viewGroup);
        }
        MsgRecord f16 = f(i3);
        if (f16.getMsgType() == 11) {
            View e16 = e(this.f447754d, f16, i3);
            this.f447756f.add((WrapperArkView) e16);
            return e16;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i3, MsgRecord msgRecord, Context context, View view) {
        Map<String, String> argumentsFromURL;
        EventCollector.getInstance().onViewClickedBefore(view);
        bc2.a.d(i3 + 1, ((IQQLiveMsgApi) QRoute.api(IQQLiveMsgApi.class)).getAdIdFromMsgRecord(msgRecord), "1");
        String a16 = a.a(msgRecord);
        int i16 = 0;
        QLog.d("MessageReceivingAdapter", 1, "createWrapArkView url=", a16);
        if (!TextUtils.isEmpty(a16)) {
            String b16 = cc2.c.b(cc2.c.b(a16, "fromid", String.valueOf(BaseConstants.ERR_SVR_COMM_RSP_JSON_PARSE_FAILED)), "startsrc", String.valueOf(BaseConstants.ERR_SVR_COMM_RSP_JSON_PARSE_FAILED));
            try {
                String a17 = cc2.c.a(b16, "roomid");
                if (!TextUtils.isEmpty(a17)) {
                    i16 = Integer.parseInt(a17);
                }
                if (i16 == 0 && b16.contains("to=mqqapi") && (argumentsFromURL = URLUtil.getArgumentsFromURL(b16)) != null && argumentsFromURL.containsKey("to") && context != null) {
                    String str = argumentsFromURL.get("to");
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                    }
                }
            } catch (Exception e16) {
                QLog.e("MessageReceivingAdapter", 1, "createWrapArkView exception=", e16);
            }
            if (i16 == 0 && b16.startsWith("https")) {
                Intent intent2 = new Intent();
                intent2.putExtra("url", b16);
                RouteUtils.startActivity(context, intent2, RouterConstants.UI_ROUTE_BROWSER);
            } else {
                cc2.a.b(this.f447754d, b16, i16, String.valueOf(BaseConstants.ERR_SVR_COMM_RSP_JSON_PARSE_FAILED), String.valueOf(BaseConstants.ERR_SVR_COMM_RSP_JSON_PARSE_FAILED), cc2.c.a(b16, "platform"));
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof WrapperArkView) {
            WrapperArkView wrapperArkView = (WrapperArkView) obj;
            wrapperArkView.b();
            this.f447756f.remove(wrapperArkView);
        }
    }

    public MsgRecord f(int i3) {
        List<MsgRecord> list = this.f447755e;
        if (list != null && i3 < list.size()) {
            return this.f447755e.get(i3);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<MsgRecord> list = this.f447755e;
        if (list != null && list.size() != 0) {
            if (this.f447755e.size() >= 5) {
                return 5;
            }
            return this.f447755e.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        View h16 = h(viewGroup, i3);
        viewGroup.addView(h16);
        return h16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void j(List<MsgRecord> list) {
        this.f447755e = list;
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.f447756f.size() > 0) {
            Iterator<WrapperArkView> it = this.f447756f.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f447756f.clear();
        }
    }
}
