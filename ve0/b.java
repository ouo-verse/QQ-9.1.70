package ve0;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f441501a;

    /* renamed from: b, reason: collision with root package name */
    public CertifiedAccountMeta$StFeed f441502b;

    /* renamed from: c, reason: collision with root package name */
    public String f441503c;

    /* renamed from: d, reason: collision with root package name */
    public CertifiedAccountMeta$StShare f441504d;

    /* renamed from: e, reason: collision with root package name */
    public ExtraTypeInfo f441505e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f441506f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f441507g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f441508h = true;

    public CertifiedAccountMeta$StFeed a() {
        return this.f441502b;
    }

    public String b() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.cover.url.get())) {
            QLog.e("ShareInfoBean", 1, this.f441504d.cover.url.get());
            return this.f441504d.cover.url.get();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f441502b;
        if (certifiedAccountMeta$StFeed != null) {
            ExtraTypeInfo extraTypeInfo = this.f441505e;
            if (extraTypeInfo != null && extraTypeInfo.pageType == 7002) {
                return certifiedAccountMeta$StFeed.poster.icon.get();
            }
            return certifiedAccountMeta$StFeed.cover.url.get();
        }
        return "";
    }

    public String c() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.desc.get())) {
            QLog.e("ShareInfoBean", 1, this.f441504d.desc.get());
            return this.f441504d.desc.get();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f441502b;
        if (certifiedAccountMeta$StFeed != null) {
            ExtraTypeInfo extraTypeInfo = this.f441505e;
            if (extraTypeInfo != null && extraTypeInfo.pageType == 7002) {
                return certifiedAccountMeta$StFeed.poster.desc.get();
            }
            return certifiedAccountMeta$StFeed.subtitle.get();
        }
        return "";
    }

    public String d() {
        ExtraTypeInfo extraTypeInfo;
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.url.get())) {
            QLog.e("ShareInfoBean", 1, this.f441504d.url.get());
            return this.f441504d.url.get();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f441502b;
        String str = "";
        if (certifiedAccountMeta$StFeed != null && (extraTypeInfo = this.f441505e) != null) {
            int i3 = extraTypeInfo.pageType;
            if (i3 != 8001) {
                switch (i3) {
                    case 7000:
                        str = SubscribeShareHelper.G(certifiedAccountMeta$StFeed);
                        break;
                    case 7001:
                        str = SubscribeShareHelper.C(certifiedAccountMeta$StFeed);
                        break;
                    case 7002:
                        str = SubscribeShareHelper.D(certifiedAccountMeta$StFeed);
                        break;
                    default:
                        String str2 = this.f441503c;
                        if (str2 != null) {
                            str = str2;
                            break;
                        }
                        break;
                }
            } else {
                str = SubscribeShareHelper.F(certifiedAccountMeta$StFeed);
            }
            QLog.d("ShareInfoBean", 1, "share url is:" + str);
            return str;
        }
        String str3 = this.f441503c;
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    public String e() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.author.desc.get())) {
            return this.f441504d.author.desc.get();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f441502b;
        if (certifiedAccountMeta$StFeed != null) {
            return certifiedAccountMeta$StFeed.poster.desc.get();
        }
        return "";
    }

    public String f() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.author.nick.get())) {
            return this.f441504d.author.nick.get();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f441502b;
        if (certifiedAccountMeta$StFeed != null) {
            return certifiedAccountMeta$StFeed.poster.nick.get();
        }
        return "";
    }

    public String g() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.shorturl.get())) {
            return this.f441504d.shorturl.get();
        }
        return "";
    }

    public String h() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null && !StringUtil.isEmpty(certifiedAccountMeta$StShare.title.get())) {
            QLog.e("ShareInfoBean", 1, this.f441504d.title.get());
            return this.f441504d.title.get();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f441502b;
        if (certifiedAccountMeta$StFeed != null) {
            ExtraTypeInfo extraTypeInfo = this.f441505e;
            if (extraTypeInfo != null && extraTypeInfo.pageType == 7002) {
                return certifiedAccountMeta$StFeed.poster.nick.get();
            }
            return certifiedAccountMeta$StFeed.title.get();
        }
        return "";
    }

    public String i() {
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare = this.f441504d;
        if (certifiedAccountMeta$StShare != null) {
            return certifiedAccountMeta$StShare.author.f24929id.get();
        }
        return "";
    }
}
