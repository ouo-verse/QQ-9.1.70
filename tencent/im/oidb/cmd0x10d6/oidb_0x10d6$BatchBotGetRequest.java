package tencent.im.oidb.cmd0x10d6;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$BatchBotGetRequest extends MessageMicro<oidb_0x10d6$BatchBotGetRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72}, new String[]{"uins", WidgetCacheConstellationData.NUM, "guild_id", "channel_id", "client_info", "tinyids", "page", "scene", "filter"}, new Object[]{0L, 0, 0L, 0L, null, 0L, 0, 0L, 0L}, oidb_0x10d6$BatchBotGetRequest.class);
    public final PBUInt64Field channel_id;
    public oidb_0x10d6$ClientInfo client_info;
    public final PBUInt64Field filter;
    public final PBUInt64Field guild_id;
    public final PBUInt32Field num;
    public final PBInt32Field page;
    public final PBUInt64Field scene;
    public final PBRepeatField<Long> tinyids;
    public final PBRepeatField<Long> uins;

    public oidb_0x10d6$BatchBotGetRequest() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uins = PBField.initRepeat(pBUInt64Field);
        this.num = PBField.initUInt32(0);
        this.guild_id = PBField.initUInt64(0L);
        this.channel_id = PBField.initUInt64(0L);
        this.client_info = new oidb_0x10d6$ClientInfo();
        this.tinyids = PBField.initRepeat(pBUInt64Field);
        this.page = PBField.initInt32(0);
        this.scene = PBField.initUInt64(0L);
        this.filter = PBField.initUInt64(0L);
    }
}
