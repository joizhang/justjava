package com.joizhang.imooc.session;

import org.apache.shiro.session.mgt.SimpleSession;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class ShiroSession extends SimpleSession implements Serializable {

    /**
     * 除lastAccessTime以外其他字段发生改变时为true
     */
    private boolean isChanged;

    ShiroSession() {
        super();
        this.setChanged(true);
    }

    ShiroSession(String host) {
        super(host);
        this.setChanged(true);
    }


    @Override
    public void setId(final Serializable id) {
        super.setId(id);
        this.setChanged(true);
    }

    @Override
    public void setStopTimestamp(final Date stopTimestamp) {
        super.setStopTimestamp(stopTimestamp);
        this.setChanged(true);
    }

    @Override
    public void setExpired(final boolean expired) {
        super.setExpired(expired);
        this.setChanged(true);
    }

    @Override
    public void setTimeout(final long timeout) {
        super.setTimeout(timeout);
        this.setChanged(true);
    }

    @Override
    public void setHost(final String host) {
        super.setHost(host);
        this.setChanged(true);
    }

    @Override
    public void setAttributes(final Map<Object, Object> attributes) {
        super.setAttributes(attributes);
        this.setChanged(true);
    }

    @Override
    public void setLastAccessTime(final Date lastAccessTime) {
        if (getLastAccessTime() != null) {
            long last = getLastAccessTime().getTime();
            long now = lastAccessTime.getTime();
            //如果10s内访问 则不更新session,否则需要更新远端过期时间
            if ((last - now) / 1000 >= 10) {
                //发送通知
                //设置为已改变，更新到redis
                this.setChanged(true);
            }
        }
        super.setLastAccessTime(lastAccessTime);
    }


    @Override
    public void setAttribute(final Object key,
                             final Object value) {
        super.setAttribute(key, value);
        this.setChanged(true);
    }

    @Override
    public Object removeAttribute(final Object key) {
        this.setChanged(true);
        return super.removeAttribute(key);
    }

    /**
     * 停止
     */
    @Override
    public void stop() {
        super.stop();
        this.setChanged(true);
    }

    /**
     * 设置过期
     */
    @Override
    protected void expire() {
        this.stop();
        this.setExpired(true);
    }


    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(final boolean isChanged) {
        this.isChanged = isChanged;
    }

}
