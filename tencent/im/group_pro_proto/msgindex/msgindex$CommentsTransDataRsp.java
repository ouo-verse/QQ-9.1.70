package tencent.im.group_pro_proto.msgindex;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgindex$CommentsTransDataRsp extends MessageMicro<msgindex$CommentsTransDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null}, msgindex$CommentsTransDataRsp.class);
    public final PBRepeatMessageField<Result> results = PBField.initRepeatMessage(Result.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Result extends MessageMicro<Result> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"guild_id", "channel_id", "seq", "trans_data"}, new Object[]{0L, 0L, 0L, ByteStringMicro.EMPTY}, Result.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field seq = PBField.initUInt64(0);
        public final PBBytesField trans_data = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
