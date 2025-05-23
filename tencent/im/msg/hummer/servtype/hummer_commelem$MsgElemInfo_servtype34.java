package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype34 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype34> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext;
    public final PBBytesField from_nickname;
    public GameSession game_session;
    public final PBUInt32Field push_window_flag;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GameSession extends MessageMicro<GameSession> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField from_open_id;
        public final PBBytesField from_role_id;
        public final PBUInt64Field from_tiny_id;
        public final PBUInt64Field game_appid;
        public final PBBytesField to_open_id;
        public final PBBytesField to_role_id;
        public final PBUInt64Field to_tiny_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56}, new String[]{"from_role_id", "from_open_id", "to_role_id", "to_open_id", "game_appid", "from_tiny_id", "to_tiny_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, 0L}, GameSession.class);
        }

        public GameSession() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.from_role_id = PBField.initBytes(byteStringMicro);
            this.from_open_id = PBField.initBytes(byteStringMicro);
            this.to_role_id = PBField.initBytes(byteStringMicro);
            this.to_open_id = PBField.initBytes(byteStringMicro);
            this.game_appid = PBField.initUInt64(0L);
            this.from_tiny_id = PBField.initUInt64(0L);
            this.to_tiny_id = PBField.initUInt64(0L);
        }
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"from_nickname", "push_window_flag", "game_session", "bytes_ext"}, new Object[]{byteStringMicro, 0, null, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype34.class);
    }

    public hummer_commelem$MsgElemInfo_servtype34() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.from_nickname = PBField.initBytes(byteStringMicro);
        this.push_window_flag = PBField.initUInt32(0);
        this.game_session = new GameSession();
        this.bytes_ext = PBField.initBytes(byteStringMicro);
    }
}
