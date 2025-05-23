package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowStickerSearch$CircleEditFirstSearchReq extends MessageMicro<ShadowStickerSearch$CircleEditFirstSearchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"search_text", "uin", "lightsdk_version", "first_sticker_page_size", "first_expression_page_size"}, new Object[]{"", "", "", 0, 0}, ShadowStickerSearch$CircleEditFirstSearchReq.class);
    public final PBStringField search_text = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBStringField lightsdk_version = PBField.initString("");
    public final PBUInt32Field first_sticker_page_size = PBField.initUInt32(0);
    public final PBUInt32Field first_expression_page_size = PBField.initUInt32(0);
}
