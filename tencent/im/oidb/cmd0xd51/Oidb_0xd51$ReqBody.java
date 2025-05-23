package tencent.im.oidb.cmd0xd51;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd51$ReqBody extends MessageMicro<Oidb_0xd51$ReqBody> {
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
    public final PBBytesField bytes_lovers;
    public final PBBytesField bytes_music_switch;
    public final PBBytesField bytes_mutualmark_alienation;
    public final PBBytesField bytes_mutualmark_score;
    public final PBBytesField bytes_my_online_status_visible_to_frd;
    public final PBBytesField bytes_my_steal_record;
    public final PBBytesField bytes_poke_friend;
    public final PBBytesField bytes_praise;
    public final PBBytesField bytes_qzone_house;
    public final PBBytesField bytes_qzone_love;
    public final PBBytesField bytes_unread_message;
    public final PBBytesField bytes_visitor_record;
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field frd_uin = PBField.initUInt64(0);
    public final PBUInt32Field add_direction = PBField.initUInt32(0);
    public final PBEnumField ext_sns_type = PBField.initEnum(1);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 88010, 168010, 248010, 328010, 408010, 488010, 568010, 648010, 728010, 808010, 888010, 968010, 1048010, 1128010, 1688010, 1768010, 1768018, 1848010, 1848018, 1848026, 1928010, 2008010, 2168010}, new String[]{"appid", "frd_uin", "add_direction", "ext_sns_type", "bytes_lovers", "bytes_confidante", "bytes_buddy", "bytes_frd_tree", "bytes_chat", "bytes_praise", "bytes_qzone_love", "bytes_qzone_house", "bytes_music_switch", "bytes_mutualmark_alienation", "bytes_unread_message", "bytes_boat", "bytes_close_frd", "bytes_mutualmark_score", "bytes_dont_forget_me", "bytes_my_online_status_visible_to_frd", "bytes_frd_online_status_visible_to_me", "bytes_visitor_record", "bytes_frd_steal_record", "bytes_my_steal_record", "bytes_avgame", "bytes_aio_quick_app", "bytes_poke_friend"}, new Object[]{0L, 0L, 0, 1, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, Oidb_0xd51$ReqBody.class);
    }

    public Oidb_0xd51$ReqBody() {
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
        this.bytes_dont_forget_me = PBField.initBytes(byteStringMicro);
        this.bytes_my_online_status_visible_to_frd = PBField.initBytes(byteStringMicro);
        this.bytes_frd_online_status_visible_to_me = PBField.initBytes(byteStringMicro);
        this.bytes_visitor_record = PBField.initBytes(byteStringMicro);
        this.bytes_frd_steal_record = PBField.initBytes(byteStringMicro);
        this.bytes_my_steal_record = PBField.initBytes(byteStringMicro);
        this.bytes_avgame = PBField.initBytes(byteStringMicro);
        this.bytes_aio_quick_app = PBField.initBytes(byteStringMicro);
        this.bytes_poke_friend = PBField.initBytes(byteStringMicro);
    }
}
