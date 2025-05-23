package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$NearbyNowData extends MessageMicro<cmd0xac5$NearbyNowData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_more_anchor_url;
    public final PBBytesField bytes_more_video_url;
    public final PBInt32Field is_authen;
    public final PBRepeatMessageField<cmd0xac5$NearbyLabelInfo> label_info;
    public cmd0xac5$MasterState master_state;
    public cmd0xac5$NowConfig msg_now_config;
    public cmd0xac5$NowAnchorState now_anchor_state;
    public final PBInt32Field now_msg_switch;
    public final PBUInt64Field uint64_uid;
    public final PBRepeatMessageField<cmd0xac5$NowHaiWan> rpt_msg_now_haiwan = PBField.initRepeatMessage(cmd0xac5$NowHaiWan.class);
    public final PBRepeatMessageField<cmd0xac5$NowFollowAnchor> rpt_msg_now_follow_anchor = PBField.initRepeatMessage(cmd0xac5$NowFollowAnchor.class);
    public final PBRepeatMessageField<cmd0xac5$NowVideoFeed> rpt_msg_now_video_feed = PBField.initRepeatMessage(cmd0xac5$NowVideoFeed.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88, 96}, new String[]{"rpt_msg_now_haiwan", "rpt_msg_now_follow_anchor", "rpt_msg_now_video_feed", "bytes_more_anchor_url", "bytes_more_video_url", "msg_now_config", "master_state", "now_anchor_state", "label_info", "is_authen", "now_msg_switch", "uint64_uid"}, new Object[]{null, null, null, byteStringMicro, byteStringMicro, null, null, null, null, 0, 0, 0L}, cmd0xac5$NearbyNowData.class);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [tencent.im.oidb.cmd0xac5.cmd0xac5$NowAnchorState] */
    /* JADX WARN: Type inference failed for: r0v8, types: [tencent.im.oidb.cmd0xac5.cmd0xac5$NowConfig] */
    /* JADX WARN: Type inference failed for: r0v9, types: [tencent.im.oidb.cmd0xac5.cmd0xac5$MasterState] */
    public cmd0xac5$NearbyNowData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_more_anchor_url = PBField.initBytes(byteStringMicro);
        this.bytes_more_video_url = PBField.initBytes(byteStringMicro);
        this.msg_now_config = new MessageMicro<cmd0xac5$NowConfig>() { // from class: tencent.im.oidb.cmd0xac5.cmd0xac5$NowConfig
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_live_boardcast_gif_url"}, new Object[]{ByteStringMicro.EMPTY}, cmd0xac5$NowConfig.class);
            public final PBBytesField bytes_live_boardcast_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.master_state = new MessageMicro<cmd0xac5$MasterState>() { // from class: tencent.im.oidb.cmd0xac5.cmd0xac5$MasterState
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_state", "bytes_jump_url"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0xac5$MasterState.class);
            public final PBUInt32Field uint32_state = PBField.initUInt32(0);
            public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.now_anchor_state = new MessageMicro<cmd0xac5$NowAnchorState>() { // from class: tencent.im.oidb.cmd0xac5.cmd0xac5$NowAnchorState
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_level", "uint32_live_status", "bytes_live_url"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, cmd0xac5$NowAnchorState.class);
            public final PBUInt32Field uint32_level = PBField.initUInt32(0);
            public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
            public final PBBytesField bytes_live_url = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.label_info = PBField.initRepeatMessage(cmd0xac5$NearbyLabelInfo.class);
        this.is_authen = PBField.initInt32(0);
        this.now_msg_switch = PBField.initInt32(0);
        this.uint64_uid = PBField.initUInt64(0L);
    }
}
