package vt1;

import com.tencent.mobileqq.activity.guild.GuildSendTextMsgCallback;
import com.tencent.mobileqq.guild.message.base.e;
import com.tencent.mobileqq.guild.message.base.f;
import com.tencent.mobileqq.guild.message.base.l;
import com.tencent.mobileqq.guild.message.base.n;
import com.tencent.mobileqq.guild.message.base.o;
import com.tencent.mobileqq.guild.message.base.p;
import com.tencent.mobileqq.guild.message.data.g;
import com.tencent.mobileqq.guild.message.data.q;
import com.tencent.mobileqq.guild.message.data.r;
import com.tencent.mobileqq.guild.message.data.s;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends l>> f443339a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends com.tencent.mobileqq.guild.message.base.d>> f443340b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends e>> f443341c;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends p>> f443342d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends n>> f443343e;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends o>> f443344f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_GuildCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends f>> f443345g;

    static {
        ArrayList<Class<? extends l>> arrayList = new ArrayList<>();
        f443339a = arrayList;
        arrayList.add(GuildSendTextMsgCallback.class);
        f443339a.add(g.class);
        ArrayList<Class<? extends com.tencent.mobileqq.guild.message.base.d>> arrayList2 = new ArrayList<>();
        f443340b = arrayList2;
        arrayList2.add(com.tencent.mobileqq.activity.guild.a.class);
        f443340b.add(com.tencent.mobileqq.guild.message.data.c.class);
        f443340b.add(com.tencent.mobileqq.guild.message.data.d.class);
        ArrayList<Class<? extends e>> arrayList3 = new ArrayList<>();
        f443341c = arrayList3;
        arrayList3.add(com.tencent.mobileqq.activity.guild.b.class);
        ArrayList<Class<? extends p>> arrayList4 = new ArrayList<>();
        f443342d = arrayList4;
        arrayList4.add(s.class);
        ArrayList<Class<? extends n>> arrayList5 = new ArrayList<>();
        f443343e = arrayList5;
        arrayList5.add(com.tencent.mobileqq.guild.message.data.n.class);
        f443343e.add(com.tencent.mobileqq.guild.message.data.o.class);
        f443343e.add(r.class);
        f443343e.add(q.class);
        ArrayList<Class<? extends o>> arrayList6 = new ArrayList<>();
        f443344f = arrayList6;
        arrayList6.add(com.tencent.mobileqq.guild.message.data.l.class);
        ArrayList<Class<? extends f>> arrayList7 = new ArrayList<>();
        f443345g = arrayList7;
        arrayList7.add(dn1.a.class);
    }
}
