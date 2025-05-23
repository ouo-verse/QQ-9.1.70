package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class PasswdUrlReport$UploadReqItem extends MessageMicro<PasswdUrlReport$UploadReqItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"url", "origin_url", "text_features", "js_func_features", "screenshot", "title", "uin", "passwd_show", "passwd_input"}, new Object[]{"", "", "", "", "", "", ByteStringMicro.EMPTY, 0, 0}, PasswdUrlReport$UploadReqItem.class);
    public final PBRepeatField<String> js_func_features;
    public final PBInt32Field passwd_input;
    public final PBInt32Field passwd_show;
    public final PBStringField screenshot;
    public final PBRepeatField<String> text_features;
    public final PBStringField title;
    public final PBBytesField uin;
    public final PBStringField url = PBField.initString("");
    public final PBStringField origin_url = PBField.initString("");

    public PasswdUrlReport$UploadReqItem() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.text_features = PBField.initRepeat(pBStringField);
        this.js_func_features = PBField.initRepeat(pBStringField);
        this.screenshot = PBField.initString("");
        this.title = PBField.initString("");
        this.uin = PBField.initBytes(ByteStringMicro.EMPTY);
        this.passwd_show = PBField.initInt32(0);
        this.passwd_input = PBField.initInt32(0);
    }
}
