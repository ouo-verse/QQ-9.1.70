package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowStickerSearch$CircleEditFirstSearchRsp extends MessageMicro<ShadowStickerSearch$CircleEditFirstSearchRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ShadowStickerSearch$MaterialInfo> sticker_materials = PBField.initRepeatMessage(ShadowStickerSearch$MaterialInfo.class);
    public final PBBoolField has_next_sticker = PBField.initBool(false);
    public final PBRepeatMessageField<ShadowStickerSearch$QQExpressionInfo> express_infos = PBField.initRepeatMessage(ShadowStickerSearch$QQExpressionInfo.class);
    public final PBBoolField has_next_express = PBField.initBool(false);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"sticker_materials", "has_next_sticker", "express_infos", "has_next_express", "ret_code", "ret_msg"}, new Object[]{null, bool, null, bool, 0, ""}, ShadowStickerSearch$CircleEditFirstSearchRsp.class);
    }
}
