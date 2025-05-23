package tencent.im.oidb.cmd0xafc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xafc$ReqBody extends MessageMicro<cmd0xafc$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_nearby_enter", "msg_nearby_exit", "msg_heart_beat"}, new Object[]{null, null, null}, cmd0xafc$ReqBody.class);
    public cmd0xafc$NearbyEnter msg_nearby_enter = new MessageMicro<cmd0xafc$NearbyEnter>() { // from class: tencent.im.oidb.cmd0xafc.cmd0xafc$NearbyEnter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_location"}, new Object[]{null}, cmd0xafc$NearbyEnter.class);
        public cmd0xafc$Location msg_location = new MessageMicro<cmd0xafc$Location>() { // from class: tencent.im.oidb.cmd0xafc.cmd0xafc$Location
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_lat", "int32_lon", "int32_coo"}, new Object[]{0, 0, 0}, cmd0xafc$Location.class);
            public final PBInt32Field int32_lat = PBField.initInt32(0);
            public final PBInt32Field int32_lon = PBField.initInt32(0);
            public final PBInt32Field int32_coo = PBField.initInt32(0);
        };
    };
    public cmd0xafc$NearbyExit msg_nearby_exit = new MessageMicro<cmd0xafc$NearbyExit>() { // from class: tencent.im.oidb.cmd0xafc.cmd0xafc$NearbyExit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0xafc$NearbyExit.class);
    };
    public cmd0xafc$HeartBeat msg_heart_beat = new MessageMicro<cmd0xafc$HeartBeat>() { // from class: tencent.im.oidb.cmd0xafc.cmd0xafc$HeartBeat
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0xafc$HeartBeat.class);
    };
}
