package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype24 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype24> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"limit_chat_enter", "limit_chat_exit"}, new Object[]{null, null}, hummer_commelem$MsgElemInfo_servtype24.class);
    public LimitChatEnter limit_chat_enter = new LimitChatEnter();
    public LimitChatExit limit_chat_exit = new LimitChatExit();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LimitChatEnter extends MessageMicro<LimitChatEnter> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_match_nick;
        public final PBBytesField bytes_tips_wording;
        public final PBUInt32Field uint32_c2c_expired_time;
        public final PBUInt32Field uint32_left_chat_time;
        public final PBUInt32Field uint32_match_expired_time;
        public final PBUInt64Field uint64_match_ts;
        public final PBUInt64Field uint64_ready_ts;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58}, new String[]{"bytes_tips_wording", "uint32_left_chat_time", "uint64_match_ts", "uint32_match_expired_time", "uint32_c2c_expired_time", "uint64_ready_ts", "bytes_match_nick"}, new Object[]{byteStringMicro, 0, 0L, 0, 0, 0L, byteStringMicro}, LimitChatEnter.class);
        }

        public LimitChatEnter() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_tips_wording = PBField.initBytes(byteStringMicro);
            this.uint32_left_chat_time = PBField.initUInt32(0);
            this.uint64_match_ts = PBField.initUInt64(0L);
            this.uint32_match_expired_time = PBField.initUInt32(0);
            this.uint32_c2c_expired_time = PBField.initUInt32(0);
            this.uint64_ready_ts = PBField.initUInt64(0L);
            this.bytes_match_nick = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LimitChatExit extends MessageMicro<LimitChatExit> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_exit_method", "uint64_match_ts"}, new Object[]{0, 0L}, LimitChatExit.class);
        public final PBUInt32Field uint32_exit_method = PBField.initUInt32(0);
        public final PBUInt64Field uint64_match_ts = PBField.initUInt64(0);
    }
}
