package tencent.im.msg;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class element_ext_buf_for_ui$ElementExtBufForUI extends MessageMicro<element_ext_buf_for_ui$ElementExtBufForUI> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56}, new String[]{"sourcePath", "thumbPath", CustomImageProps.QUALITY, "thumbWidth", "thumbHeight", "thumbMd5", "thumbSize"}, new Object[]{"", "", 0, 0, 0, "", 0L}, element_ext_buf_for_ui$ElementExtBufForUI.class);
    public final PBStringField sourcePath = PBField.initString("");
    public final PBStringField thumbPath = PBField.initString("");
    public final PBBoolField quality = PBField.initBool(false);
    public final PBUInt32Field thumbWidth = PBField.initUInt32(0);
    public final PBUInt32Field thumbHeight = PBField.initUInt32(0);
    public final PBStringField thumbMd5 = PBField.initString("");
    public final PBUInt64Field thumbSize = PBField.initUInt64(0);
}
