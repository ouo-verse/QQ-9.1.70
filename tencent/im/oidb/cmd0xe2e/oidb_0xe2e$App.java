package tencent.im.oidb.cmd0xe2e;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe2e$App extends MessageMicro<oidb_0xe2e$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 66, 72, 80, 88, 114, 120, 128, 136, 144, 152, 162, 170}, new String[]{"appid", "type", "name", "icon", "url", "removable", "source", "desc", "added", RedTouchWebviewHandler.PLUGIN_NAMESPACE, "add_ts", "cmd_trace", "show_frame", "playing_num", "add_uin", "total_playing_num", "qq_friend_playing_num", "playing_users", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{0L, 0L, "", "", "", 0, 0, "", 0, 0, 0L, "", 0, 0, 0L, 0, 0, null, null}, oidb_0xe2e$App.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field removable = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field added = PBField.initUInt32(0);
    public final PBInt32Field redpoint = PBField.initInt32(0);
    public final PBUInt64Field add_ts = PBField.initUInt64(0);
    public final PBStringField cmd_trace = PBField.initString("");
    public final PBUInt32Field show_frame = PBField.initUInt32(0);
    public final PBUInt32Field playing_num = PBField.initUInt32(0);
    public final PBUInt64Field add_uin = PBField.initUInt64(0);
    public final PBUInt32Field total_playing_num = PBField.initUInt32(0);
    public final PBUInt32Field qq_friend_playing_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xe2e$PlayingUser> playing_users = PBField.initRepeatMessage(oidb_0xe2e$PlayingUser.class);
    public final PBRepeatMessageField<oidb_0xe2e$Tag> tags = PBField.initRepeatMessage(oidb_0xe2e$Tag.class);
}
