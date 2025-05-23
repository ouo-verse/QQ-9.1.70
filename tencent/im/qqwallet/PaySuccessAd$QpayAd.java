package tencent.im.qqwallet;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class PaySuccessAd$QpayAd extends MessageMicro<PaySuccessAd$QpayAd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"id", "title", "sub_title", "banner", "icon", "brand", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "button_url", "trace_info", "ext_info"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, PaySuccessAd$QpayAd.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f436043id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField banner = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField brand = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField button_url = PBField.initString("");
    public final PBStringField trace_info = PBField.initString("");
    public final PBStringField ext_info = PBField.initString("");
}
