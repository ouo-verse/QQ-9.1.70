package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$GameResultLikeItem extends MessageMicro<YoloRoomOuterClass$GameResultLikeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "from_uid_list"}, new Object[]{0L, 0L}, YoloRoomOuterClass$GameResultLikeItem.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBRepeatField<Long> from_uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
