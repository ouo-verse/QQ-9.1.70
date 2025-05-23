package tk;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0012"}, d2 = {"Ltk/k;", "", "Lcooperation/qzone/model/PhotoInfo;", "photoInfo", "", "a", "d", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "forwardFeedData", "", "c", "Lcooperation/qzone/model/PhotoParam;", "photoParam", "b", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f436438a = new k();

    k() {
    }

    public final boolean d() {
        if (!RFWApplication.isPublicVersion()) {
            return gd.a.f401926a.c("KEY_ENABLE_NEW_LOCAL_GALLERY", true);
        }
        return com.qzone.reborn.configx.g.f53821a.b().W();
    }

    public final boolean a(PhotoInfo photoInfo) {
        return (photoInfo == null || photoInfo.photoType == 2) ? false : true;
    }

    public final long b(PhotoParam photoParam) {
        if (photoParam == null) {
            return 0L;
        }
        long j3 = photoParam.realOwnerUin;
        return j3 > 10001 ? j3 : photoParam.ownerUin;
    }

    public final long c(BusinessFeedData feedData, BusinessFeedData forwardFeedData) {
        User user;
        User user2;
        if (((feedData == null || (user2 = feedData.getUser()) == null) ? null : Long.valueOf(user2.uin)) != null && feedData.getUser().uin > 10001) {
            return feedData.getUser().uin;
        }
        if (forwardFeedData == null || (user = forwardFeedData.getUser()) == null) {
            return 0L;
        }
        return user.uin;
    }

    public final boolean e(PhotoParam photoParam) {
        if (photoParam == null) {
            return false;
        }
        if (photoParam.loginUin != 0) {
            if (f436438a.b(photoParam) == photoParam.loginUin) {
                return false;
            }
        } else if (f436438a.b(photoParam) == LoginData.getInstance().getUin()) {
            return false;
        }
        return true;
    }
}
