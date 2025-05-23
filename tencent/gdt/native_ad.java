package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class native_ad {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetNativeAdReq extends MessageMicro<GetNativeAdReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feedid", "ad_get_req", "client_mod"}, new Object[]{"", null, ""}, GetNativeAdReq.class);
        public final PBStringField feedid = PBField.initString("");
        public qq_ad_get.QQAdGet ad_get_req = new qq_ad_get.QQAdGet();
        public final PBStringField client_mod = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GetNativeAdRsp extends MessageMicro<GetNativeAdRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"hit", "native_ad"}, new Object[]{Boolean.FALSE, null}, GetNativeAdRsp.class);
        public final PBBoolField hit = PBField.initBool(false);
        public NativeAd native_ad = new NativeAd();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class NativeAd extends MessageMicro<NativeAd> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ad_get_rsp"}, new Object[]{null}, NativeAd.class);
        public qq_ad_get.QQAdGetRsp ad_get_rsp = new qq_ad_get.QQAdGetRsp();
    }

    native_ad() {
    }
}
