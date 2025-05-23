package trpc.yes.common;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomBlackListRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomBlackListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uid_list", "server_key", PictureConst.KEY_HAS_MORE}, new Object[]{0L, ByteStringMicro.EMPTY, Boolean.FALSE}, YoloRoomOuterClass$YoloRoomBlackListRsp.class);
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField server_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField has_more = PBField.initBool(false);
}
