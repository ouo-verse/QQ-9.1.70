package qzone;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ShuoShuoInfoReq extends MessageMicro<QzoneActivityPB$ShuoShuoInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"uid", "tid", "tid_create_time", "shuoshuo_text", "ext_infos", WidgetCacheQzoneVipData.ISVIP}, new Object[]{"", "", 0L, ByteStringMicro.EMPTY, null, Boolean.FALSE}, QzoneActivityPB$ShuoShuoInfoReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField tid = PBField.initString("");
    public final PBInt64Field tid_create_time = PBField.initInt64(0);
    public final PBBytesField shuoshuo_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<QzoneActivityPB$KVInfo> ext_infos = PBField.initRepeatMessage(QzoneActivityPB$KVInfo.class);
    public final PBBoolField is_vip = PBField.initBool(false);
}
