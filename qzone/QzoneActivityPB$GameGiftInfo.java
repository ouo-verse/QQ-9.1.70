package qzone;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$GameGiftInfo extends MessageMicro<QzoneActivityPB$GameGiftInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48}, new String[]{LocalPhotoFaceInfo.SCORE, "is_draw", "gift_res_name", "gift_activity_id", "icon", WidgetCacheConstellationData.NUM}, new Object[]{0, Boolean.FALSE, "", 0L, "", 0}, QzoneActivityPB$GameGiftInfo.class);
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBBoolField is_draw = PBField.initBool(false);
    public final PBStringField gift_res_name = PBField.initString("");
    public final PBInt64Field gift_activity_id = PBField.initInt64(0);
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
}
