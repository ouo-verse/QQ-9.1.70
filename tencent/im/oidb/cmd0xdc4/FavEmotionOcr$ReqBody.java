package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FavEmotionOcr$ReqBody extends MessageMicro<FavEmotionOcr$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"uint32_src_term", "string_version", "uint32_cmd_type", "list_pic_info", "list_modify_req", "bytes_other"}, new Object[]{0, "", 0, null, null, ByteStringMicro.EMPTY}, FavEmotionOcr$ReqBody.class);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBStringField string_version = PBField.initString("");
    public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<FavEmotionOcr$PicInfo> list_pic_info = PBField.initRepeatMessage(FavEmotionOcr$PicInfo.class);
    public final PBRepeatMessageField<FavEmotionOcr$ModifyReq> list_modify_req = PBField.initRepeatMessage(FavEmotionOcr$ModifyReq.class);
    public final PBBytesField bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
}
