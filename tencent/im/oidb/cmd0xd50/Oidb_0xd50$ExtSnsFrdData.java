package tencent.im.oidb.cmd0xd50;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd50$ExtSnsFrdData extends MessageMicro<Oidb_0xd50$ExtSnsFrdData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_aio_quick_app;
    public final PBBytesField bytes_avgame;
    public final PBBytesField bytes_boat;
    public final PBBytesField bytes_buddy;
    public final PBBytesField bytes_chat;
    public final PBBytesField bytes_close_frd;
    public final PBBytesField bytes_confidante;
    public final PBBytesField bytes_dont_forget_me;
    public final PBBytesField bytes_frd_online_status_visible_to_me;
    public final PBBytesField bytes_frd_steal_record;
    public final PBBytesField bytes_frd_tree;
    public final PBBytesField bytes_ksing_switch;
    public final PBBytesField bytes_lbs_share;
    public final PBBytesField bytes_lovers;
    public final PBBytesField bytes_music_switch;
    public final PBBytesField bytes_mutualmark_alienation;
    public final PBBytesField bytes_mutualmark_score;
    public final PBBytesField bytes_my_online_status_visible_to_frd;
    public final PBBytesField bytes_my_steal_record;
    public final PBBytesField bytes_praise;
    public final PBBytesField bytes_qzone_house;
    public final PBBytesField bytes_qzone_love;
    public final PBBytesField bytes_unread_message;
    public final PBBytesField bytes_visitor_record;
    public final PBUInt64Field frd_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 88018, 168018, 248018, 328010, 408010, 488010, 568010, 648010, 728010, 808010, 888010, 968010, 1048010, 1128010, 1208010, 1448010, 1688010, 1768010, 1768018, 1848010, 1848018, 1848026, 1928010, 2008010}, new String[]{"frd_uin", "bytes_lovers", "bytes_confidante", "bytes_buddy", "bytes_frd_tree", "bytes_chat", "bytes_praise", "bytes_qzone_love", "bytes_qzone_house", "bytes_music_switch", "bytes_mutualmark_alienation", "bytes_unread_message", "bytes_boat", "bytes_close_frd", "bytes_mutualmark_score", "bytes_ksing_switch", "bytes_lbs_share", "bytes_dont_forget_me", "bytes_my_online_status_visible_to_frd", "bytes_frd_online_status_visible_to_me", "bytes_visitor_record", "bytes_frd_steal_record", "bytes_my_steal_record", "bytes_avgame", "bytes_aio_quick_app"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, Oidb_0xd50$ExtSnsFrdData.class);
    }

    public Oidb_0xd50$ExtSnsFrdData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_lovers = PBField.initBytes(byteStringMicro);
        this.bytes_confidante = PBField.initBytes(byteStringMicro);
        this.bytes_buddy = PBField.initBytes(byteStringMicro);
        this.bytes_frd_tree = PBField.initBytes(byteStringMicro);
        this.bytes_chat = PBField.initBytes(byteStringMicro);
        this.bytes_praise = PBField.initBytes(byteStringMicro);
        this.bytes_qzone_love = PBField.initBytes(byteStringMicro);
        this.bytes_qzone_house = PBField.initBytes(byteStringMicro);
        this.bytes_music_switch = PBField.initBytes(byteStringMicro);
        this.bytes_mutualmark_alienation = PBField.initBytes(byteStringMicro);
        this.bytes_unread_message = PBField.initBytes(byteStringMicro);
        this.bytes_boat = PBField.initBytes(byteStringMicro);
        this.bytes_close_frd = PBField.initBytes(byteStringMicro);
        this.bytes_mutualmark_score = PBField.initBytes(byteStringMicro);
        this.bytes_ksing_switch = PBField.initBytes(byteStringMicro);
        this.bytes_lbs_share = PBField.initBytes(byteStringMicro);
        this.bytes_dont_forget_me = PBField.initBytes(byteStringMicro);
        this.bytes_my_online_status_visible_to_frd = PBField.initBytes(byteStringMicro);
        this.bytes_frd_online_status_visible_to_me = PBField.initBytes(byteStringMicro);
        this.bytes_visitor_record = PBField.initBytes(byteStringMicro);
        this.bytes_frd_steal_record = PBField.initBytes(byteStringMicro);
        this.bytes_my_steal_record = PBField.initBytes(byteStringMicro);
        this.bytes_avgame = PBField.initBytes(byteStringMicro);
        this.bytes_aio_quick_app = PBField.initBytes(byteStringMicro);
    }
}
