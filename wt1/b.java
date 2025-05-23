package wt1;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.message.chatpie.GuildMenuDialogFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemGuildPriorityHelper;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private GuildMenuDialogFragment f446477d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.utils.dialogutils.a f446478e;

    /* renamed from: f, reason: collision with root package name */
    private int f446479f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f446480h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f446481i = 1;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f446482a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f446483b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.mobileqq.utils.dialogutils.b f446484c;
    }

    public b(GuildMenuDialogFragment guildMenuDialogFragment) {
        this.f446477d = guildMenuDialogFragment;
    }

    private void b(a aVar, View view) {
        if (this.f446481i == 5) {
            view.setBackgroundResource(R.drawable.guild_live_chatpie_menu_item_selector);
            aVar.f446483b.setTextColor(view.getResources().getColor(R.color.f157149br0));
            aVar.f446482a.getBackground().setColorFilter(new PorterDuffColorFilter(view.getResources().getColor(R.color.f157150br1), PorterDuff.Mode.SRC_ATOP));
        }
    }

    private void d(View view, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_menu_name_button", str);
        hashMap.put("aio_menu_location_button", str2);
        hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, Integer.valueOf(this.f446479f));
        hashMap.put("sgrp_aio_source_type", Integer.valueOf(this.f446480h));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(view, "em_msg_more", hashMap);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.utils.dialogutils.b getItem(int i3) {
        if (i3 >= 0 && i3 < this.f446478e.h()) {
            return this.f446478e.f(i3);
        }
        return null;
    }

    public void c(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        this.f446478e = aVar;
        if (this.f446481i != 5) {
            QQCustomMenuItemGuildPriorityHelper.d(aVar);
        }
    }

    public void e(int i3) {
        this.f446481i = i3;
    }

    public void f(int i3) {
        this.f446479f = i3;
    }

    public void g(int i3) {
        this.f446480h = i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f446478e.h();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mobileqq.utils.dialogutils.b item = getItem(i3);
        if (item != null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eeu, viewGroup, false);
                aVar = new a();
                aVar.f446482a = (ImageView) view.findViewById(R.id.icon);
                aVar.f446483b = (TextView) view.findViewById(R.id.jfb);
                view.setTag(aVar);
                view.setOnClickListener(this);
            } else {
                aVar = (a) view.getTag();
            }
            view.setId(item.b());
            aVar.f446482a.setBackgroundDrawable(view.getResources().getDrawable(item.a()));
            aVar.f446483b.setText(item.c());
            aVar.f446484c = item;
            b(aVar, view);
            d(view, item.c(), String.valueOf(i3));
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = (a) view.getTag();
        if (aVar != null) {
            this.f446477d.wh(aVar.f446484c);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
